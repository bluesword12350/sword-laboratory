package main

import (
	"io"
	"log"
	"net/http"
	"os"
)

func main() {
	pathName := "file"
	_ = os.Mkdir(pathName, os.ModePerm)
	fileUrl := "/"
	http.Handle(fileUrl, http.StripPrefix(fileUrl, http.FileServer(http.Dir(pathName))))
	http.HandleFunc("/upload", func(writer http.ResponseWriter, request *http.Request) {
		err := request.ParseMultipartForm(32 << 20)
		if err != nil {
			log.Fatal("解析请求参数异常: ", err)
			return
		}
		files := request.MultipartForm.File["upFile"]
		uploadPathName := pathName + "/share"
		_ = os.Mkdir(uploadPathName, os.ModePerm)
		for i := range files {
			fileHeader := files[i]
			file, _ := fileHeader.Open()
			saveFile, err := os.OpenFile(uploadPathName+"/"+fileHeader.Filename, os.O_CREATE|os.O_WRONLY, os.ModePerm)
			if err != nil {
				log.Fatal("打开文件异常: ", err)
				return
			}
			_, copyErr := io.Copy(saveFile, file)
			if copyErr != nil {
				log.Fatal("复制内容异常: ", copyErr)
			}
			closeError := saveFile.Close()
			if closeError != nil {
				log.Fatal("关闭文件异常: ", closeError)
				return
			}
		}
	})
	port := ":9081"
	err := http.ListenAndServe(port, nil)
	if err != nil {
		log.Fatal("ListenAndServe error : ", err)
	}
	log.Println("开启文件服务 127.0.0.1", port)
}

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
		file, fileHeader, _ := request.FormFile("upFile")
		uploadPathName := pathName + "/share"
		_ = os.Mkdir(uploadPathName, os.ModePerm)
		saveFile, err := os.OpenFile(uploadPathName+"/"+fileHeader.Filename, os.O_CREATE|os.O_WRONLY, os.ModePerm)
		if err != nil {
			log.Fatal("OpenFile error: ", err)
		}
		io.Copy(saveFile, file)
	})
	err := http.ListenAndServe(":9081", nil)
	if err != nil {
		log.Fatal("ListenAndServe error : ", err)
	}
}

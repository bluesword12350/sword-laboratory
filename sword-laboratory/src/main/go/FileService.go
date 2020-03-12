package main

import (
	"log"
	"net/http"
	"os"
)

func main() {
	_ = os.Mkdir("file", os.ModePerm)
	http.Handle("/file/", http.StripPrefix("/file/", http.FileServer(http.Dir("file"))))
	err := http.ListenAndServe(":8080", nil)
	if err != nil {
		log.Fatal("ListenAndServe: ", err)
	}
}

package main

import (
	"log"
	"net/http"
	"os"
)

func main() {
	_ = os.Mkdir("file", os.ModePerm)
	http.Handle("/pollux/", http.StripPrefix("/pollux/", http.FileServer(http.Dir("file"))))
	err := http.ListenAndServe(":8080", nil)
	if err != nil {
		log.Fatal("ListenAndServe: ", err)
	}

}

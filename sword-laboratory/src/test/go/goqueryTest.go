package main

import (
	"github.com/PuerkitoBio/goquery"
	"io/ioutil"
	"log"
	"net/http"
	"os"
	"strconv"
	"strings"
)

func main() {
	res, err := http.Get("https://www.poco.cn")
	if err != nil {
		log.Fatal(err)
	}
	defer res.Body.Close()
	if res.StatusCode != 200 {
		log.Fatalf("status code error: %d %s", res.StatusCode, res.Status)
	}

	doc, err := goquery.NewDocumentFromReader(res.Body)
	if err != nil {
		log.Fatal(err)
	}

	img := doc.Find("img")

	img.Each(func(i int, selection *goquery.Selection) {
		val, exists := selection.Attr("data-src")
		if exists && strings.HasSuffix(val, ".jpg") {
			file, err := os.Create(strconv.Itoa(i) + ".jpg")
			if err != nil {
				log.Fatal(err)
			}
			response, err := http.Get("http:" + val)
			if err != nil {
				log.Fatal(err)
			}
			bytes, _ := ioutil.ReadAll(response.Body)
			_, _ = file.Write(bytes)
		}
	})
}

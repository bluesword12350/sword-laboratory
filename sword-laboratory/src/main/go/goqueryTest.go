package main

import (
	"github.com/PuerkitoBio/goquery"
	"log"
	"net/http"
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
		if exists && strings.HasPrefix(val, ".jpg") {

		}
	})

}

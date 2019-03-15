package main

import (
	"crypto/hmac"
	"crypto/sha256"
	"fmt"
)

func main() {
	secret := "secret"
	data := "data"
	h := hmac.New(sha256.New, []byte(secret))
	h.Write([]byte(data))
	sum := h.Sum(nil)
	fmt.Println(sum)
}

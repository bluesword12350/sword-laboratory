package main

import "C"

//export sum
func sum(a int, b int) int {
	return a + b
}

//export json
func json(a *C.char) *C.char {
	return C.CString(C.GoString(a) + "bluesword")
}

//go build -buildmode=c-shared -o ../resources/GoLibrary.dll ./GoLibrary.go
//go build -buildmode=c-shared -o ../resources/GoLibrary.so ./GoLibrary.go
func main() {
}

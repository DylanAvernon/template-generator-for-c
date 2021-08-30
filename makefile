Main: Main.c
	java UpdateMain $(ch)
	gcc Main.c -o Main
	./Main
clean:
	rm Main.exe
	rm Scaffold.class
	rm UpdateMain.class
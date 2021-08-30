#include <stdio.h>
#include <stdbool.h>
#include "./Chapter2/switch.h"
void printTitle(int program_number) {
	printf("Program %i\n", program_number);
	printf("-----------\n");
}
int main(int argc, char *argv[]) {
	int program_number;
	printf("Enter program number: ");
	scanf("%i", &program_number);
	printf("\n");
	// there is a leftover character in the console
	// from the printf()s in Main.c
	// Use getchar() hear to read and dispose of the
	// leftover character.
	getchar();
	chapterSwitch(program_number, argc, argv);
	return 0;
}
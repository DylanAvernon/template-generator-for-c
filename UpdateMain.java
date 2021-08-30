import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class UpdateMain {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Error");
            System.exit(1);
        }
        int chapterNum = Integer.parseInt(args[0]);
        PrintWriter output;
        File file = new File("./Main.c");
        try {
            output = new PrintWriter(file);
            output.print("#include <stdio.h>\n" + 
                         "#include <stdbool.h>\n" + 
                         "#include \"./Chapter" + chapterNum + "/switch.h\"\n" + 
                         "void printTitle(int program_number) {\n" +
                            "\tprintf(\"Program %i\\n\", program_number);\n" +
                            "\tprintf(\"-----------\\n\");\n" +
                         "}\n" +
                         "int main(int argc, char *argv[]) {\n" + 
                            "\tint program_number;\n" + 
                            "\tprintf(\"Enter program number: \");\n" + 
                            "\tscanf(\"%i\", &program_number);\n" + 
                            "\tprintf(\"\\n\");\n" + 
                            "\t// there is a leftover character in the console\n" + 
                            "\t// from the printf()s in Main.c\n" + 
                            "\t// Use getchar() hear to read and dispose of the\n" + 
                            "\t// leftover character.\n" + 
                            "\tgetchar();\n" + 
                            "\tchapterSwitch(program_number, argc, argv);\n" + 
                            "\treturn 0;\n" + 
                         "}");
            output.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }

    }
}

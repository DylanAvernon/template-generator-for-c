import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Scaffold {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Error");
            System.exit(1);
        }
        String folderName = args[0];
        String chapterNum = args[1];
        int exercises = Integer.parseInt(args[2]);
        String fileNameStub = "program" + chapterNum +"_";
        PrintWriter output;

        // Create Directory For Chapter
        File file = new File(folderName);
        file.mkdir();

        // Create Excercise Files
        for (int i = 1; i <= exercises; i++) {
            String fileName = folderName + "/" + fileNameStub + i + ".h";
            String mainName = fileNameStub + i + "_main";
            file = new File(fileName);
            try {
                output = new PrintWriter(file);

                output.print("int " + mainName + "(int argc, char *argv[]) {\n\treturn 0;\n}");
                output.close();
            }
            catch (FileNotFoundException e) {
                System.out.println("File Not Found");
            }
        }

        // Create switch file
        file = new File(folderName + "/switch.h");
        try {
            output = new PrintWriter(file);
            output.print("#include \"./helpers.h\"\n");
            for (int i = 1; i <= exercises; i++) {
                String includeName = "#include \"./" + fileNameStub + i + ".h\"\n";
                output.print(includeName);
            }
            output.print("void printTitle(int program_number);\n");
            output.print("void chapterSwitch(int program_number, int argc, char *argv[]) {\n\tswitch (program_number) {\n");
            for (int i = 1; i <= exercises; i++) {
                output.print("\t\tcase " + i + ":\n\t\t\tprintTitle(program_number);\n\t\t\t" + fileNameStub + i + "_main(argc, argv);\n\t\t\tbreak;\n");
            }
            output.print("\t}\n}");
            output.close();      
        }
        catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        
        // Create helper file
        file = new File(folderName + "/helpers.h");
        try {
            output = new PrintWriter(file);
            output.print("//empty file");
            output.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }

        
    }
}
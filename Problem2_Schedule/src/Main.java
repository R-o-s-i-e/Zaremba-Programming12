public class Main {
    public static void main(String[] args) {
        System.out.print("\n\n            Rosie's 2023-2024 School Schedule\n");

        //Full-Year Schedule Data
        String[]  subjects = new String[]  {"Senior Band 12",
                "AP Calculus",
                "Computer Programming 12",
                "Free Block",
                "AP Biology",
                "AP Physics 2",
                "Contemp Indigenous Studies 12",
                "Free Block"};
        String[]  teachers = new String[]  {"Mr. D", "Ms. Reed", "Mr. Zaremba", "N/A",
                "Mr. Wilkie", "Mr. Tang", "Mr. Edmondson", "N/A"};
        Integer[] block    = new Integer[] {1,2,3,4,1,2,3,4};

        //Semester 1
        System.out.print("\nSemester 1\n");

        System.out.println("----------------------------------------------------------");
        System.out.format("| %25s | %13s | %10s |\n", "Subject", "Teacher", "Block #");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < 4; i ++)
        {
            System.out.format("| %25s | %13s | %10s |\n", subjects[i], teachers[i], block[i]);
        }
        System.out.println("----------------------------------------------------------");

        //Semester 2
        System.out.println("\nSemester 2");
        System.out.println("---------------------------------------------------------------");
        System.out.format("| %30s | %13s | %10s |\n", "Subject", "Teacher", "Block #");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < 4; i ++)
        {
            System.out.format("| %30s | %13s | %10s |\n", subjects[i+4], teachers[i+4], block[i+4]);
        }
        System.out.println("---------------------------------------------------------------");
    }
}
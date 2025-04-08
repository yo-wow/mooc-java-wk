public class StructureDemoClass {
    int firstVar;
    int secondVar;
    int thirdVar = initThirdVar();

    StructureDemoClass() {
        System.out.println("structure hit");
        this.firstVar = 1;
        this.secondVar = 2;
    }

    int initThirdVar() {
        System.out.println("initThirdVar hit");
        return 3;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class Main {

    private static BigDecimal totalCredit = BigDecimal.ZERO;
    private static BigDecimal creditMultipliedGrade = BigDecimal.ZERO;

    public static void main(String[] args) throws IOException {
        init();
        printAnswer();
    }

    private static void printAnswer() {
        if (totalCredit.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println(BigDecimal.ZERO.setScale(6));
        } else {
            System.out.println(creditMultipliedGrade.divide(totalCredit, 6, RoundingMode.HALF_UP));
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            String[] input = br.readLine().split(" ");
            BigDecimal credit = new BigDecimal(input[1]);
            if (GradeEnum.findExcludeGrade(input[2])) continue;
            BigDecimal grade = GradeEnum.findGradeVal(input[2]);
            totalCredit = totalCredit.add(credit);
            creditMultipliedGrade = creditMultipliedGrade.add(credit.multiply(grade)); // Reassign the result
        }
    }
}
enum GradeEnum {

    A(new BigDecimal("4.5"), "A+")
    , A0(new BigDecimal(4), "A0")
    , B(new BigDecimal(3.5), "B+")
    , B0(new BigDecimal(3), "B0")
    , C(new BigDecimal(2.5), "C+")
    , C0(new BigDecimal(2), "C0")
    , D(new BigDecimal(1.5), "D+")
    , D0(new BigDecimal(1.0), "D0")
    , F(new BigDecimal(0.0), "F")
    , P(new BigDecimal(0.0), "P")
    ;
    private final BigDecimal gradeVal;
    private final String grade;

    GradeEnum(BigDecimal gradeVal, String grade) {
        this.gradeVal = gradeVal;
        this.grade = grade;
    }

    public static boolean findExcludeGrade(String gradeParam) {
        return GradeEnum.P.grade.equals(gradeParam);
    }

    public static BigDecimal findGradeVal(String gradeParam) {
        return Arrays.stream(GradeEnum.values())
                .filter(gradeEnum -> gradeEnum.grade.equals(gradeParam))
                .findAny().get().gradeVal;
    }
}
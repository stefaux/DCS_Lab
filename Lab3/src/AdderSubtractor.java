import java.util.EnumMap;
import java.util.Map;

public class AdderSubtractor {
    public static TwoXTwoTable createInversor() {

        Map<FuzzyValue, Map<FuzzyValue, FuzzyValue>> ruleTable1 =
                new EnumMap<>(FuzzyValue.class);
        Map<FuzzyValue, Map<FuzzyValue, FuzzyValue>> ruleTable2 =
                new EnumMap<>(FuzzyValue.class);

        //  NL Line
        Map<FuzzyValue, FuzzyValue> nlLine =
                new EnumMap<>(FuzzyValue.class);
        Map<FuzzyValue, FuzzyValue> nlLine2 =
                new EnumMap<>(FuzzyValue.class);

        ruleTable1.put(FuzzyValue.NL, nlLine);
        nlLine.put(FuzzyValue.NL, FuzzyValue.NL);
        nlLine.put(FuzzyValue.NM, FuzzyValue.NL);
        nlLine.put(FuzzyValue.ZR, FuzzyValue.NL);
        nlLine.put(FuzzyValue.PM, FuzzyValue.NM);
        nlLine.put(FuzzyValue.PL, FuzzyValue.ZR);

        ruleTable2.put(FuzzyValue.NL, nlLine2);
        nlLine2.put(FuzzyValue.NL, FuzzyValue.ZR);
        nlLine2.put(FuzzyValue.NM, FuzzyValue.NM);
        nlLine2.put(FuzzyValue.ZR, FuzzyValue.NL);
        nlLine2.put(FuzzyValue.PM, FuzzyValue.NL);
        nlLine2.put(FuzzyValue.PL, FuzzyValue.NL);

        //  NM Line
        Map<FuzzyValue, FuzzyValue> nmLine =
                new EnumMap<>(FuzzyValue.class);
        ruleTable1.put(FuzzyValue.NM, nmLine);
        nmLine.put(FuzzyValue.NL, FuzzyValue.NL);
        nmLine.put(FuzzyValue.NM, FuzzyValue.NL);
        nmLine.put(FuzzyValue.ZR, FuzzyValue.NM);
        nmLine.put(FuzzyValue.PM, FuzzyValue.ZR);
        nmLine.put(FuzzyValue.PL, FuzzyValue.PM);

        Map<FuzzyValue, FuzzyValue> nmLine2 =
                new EnumMap<>(FuzzyValue.class);
        ruleTable2.put(FuzzyValue.NM, nmLine2);
        nmLine2.put(FuzzyValue.NL, FuzzyValue.PM);
        nmLine2.put(FuzzyValue.NM, FuzzyValue.ZR);
        nmLine2.put(FuzzyValue.ZR, FuzzyValue.NM);
        nmLine2.put(FuzzyValue.PM, FuzzyValue.NL);
        nmLine2.put(FuzzyValue.PL, FuzzyValue.NL);

        //  ZR Line
        Map<FuzzyValue, FuzzyValue> zrLine =
                new EnumMap<>(FuzzyValue.class);
        ruleTable1.put(FuzzyValue.ZR, zrLine);
        zrLine.put(FuzzyValue.NL, FuzzyValue.NL);
        zrLine.put(FuzzyValue.NM, FuzzyValue.NM);
        zrLine.put(FuzzyValue.ZR, FuzzyValue.ZR);
        zrLine.put(FuzzyValue.PM, FuzzyValue.PM);
        zrLine.put(FuzzyValue.PL, FuzzyValue.PL);

        Map<FuzzyValue, FuzzyValue> zrLine2 =
                new EnumMap<>(FuzzyValue.class);
        ruleTable2.put(FuzzyValue.ZR, zrLine2);
        zrLine2.put(FuzzyValue.NL, FuzzyValue.PL);
        zrLine2.put(FuzzyValue.NM, FuzzyValue.PM);
        zrLine2.put(FuzzyValue.ZR, FuzzyValue.ZR);
        zrLine2.put(FuzzyValue.PM, FuzzyValue.NM);
        zrLine2.put(FuzzyValue.PL, FuzzyValue.NL);

        //  PM Line
        Map<FuzzyValue, FuzzyValue> pmLine =
                new EnumMap<>(FuzzyValue.class);
        ruleTable1.put(FuzzyValue.PM, pmLine);
        pmLine.put(FuzzyValue.NL, FuzzyValue.NM);
        pmLine.put(FuzzyValue.NM, FuzzyValue.ZR);
        pmLine.put(FuzzyValue.ZR, FuzzyValue.PM);
        pmLine.put(FuzzyValue.PM, FuzzyValue.PL);
        pmLine.put(FuzzyValue.PL, FuzzyValue.PL);

        Map<FuzzyValue, FuzzyValue> pmLine2 =
                new EnumMap<>(FuzzyValue.class);
        ruleTable2.put(FuzzyValue.PM, pmLine2);
        pmLine2.put(FuzzyValue.NL, FuzzyValue.PL);
        pmLine2.put(FuzzyValue.NM, FuzzyValue.PL);
        pmLine2.put(FuzzyValue.ZR, FuzzyValue.PM);
        pmLine2.put(FuzzyValue.PM, FuzzyValue.ZR);
        pmLine2.put(FuzzyValue.PL, FuzzyValue.NM);

        //  PL Line
        Map<FuzzyValue, FuzzyValue> plLine =
                new EnumMap<>(FuzzyValue.class);
        ruleTable1.put(FuzzyValue.PL, plLine);
        plLine.put(FuzzyValue.NL, FuzzyValue.ZR);
        plLine.put(FuzzyValue.NM, FuzzyValue.PM);
        plLine.put(FuzzyValue.ZR, FuzzyValue.PL);
        plLine.put(FuzzyValue.PM, FuzzyValue.PL);
        plLine.put(FuzzyValue.PL, FuzzyValue.PL);

        Map<FuzzyValue, FuzzyValue> plLine2 =
                new EnumMap<>(FuzzyValue.class);
        ruleTable2.put(FuzzyValue.PL, plLine2);
        plLine2.put(FuzzyValue.NL, FuzzyValue.PL);
        plLine2.put(FuzzyValue.NM, FuzzyValue.PL);
        plLine2.put(FuzzyValue.ZR, FuzzyValue.PL);
        plLine2.put(FuzzyValue.PM, FuzzyValue.PM);
        plLine2.put(FuzzyValue.PL, FuzzyValue.ZR);

//returning FLRS table with two inputs and two outputs
        return new TwoXTwoTable(ruleTable1, ruleTable2);
    }

    public static void main(String[] args) {
        double w1 = 1;
        double w2 = 1;

//specifying the limits for fuzzyfication, defuzzyfication
        FuzzyDefuzzy fuzDefuz =
                new FuzzyDefuzzy(-1.0, -0.5, 0.0, 0.5, 1.0);

//creating FLRS table for tow inputs and two outputs
        TwoXTwoTable inversor =  createInversor();

//giving the two inputs
        double x1 = 0.1;
        double x2 = 0.2;
        double x3;
        double x4;

        if ((w1 * x1 + w2 * x2) < -1 ) {
            x3 = -1;
            System.out.println("x3 :: " + x3);
        }
        else if ((w1 * x1 + w2 * x2) > 1 ) {
            x3 = 1;
            System.out.println("x3 :: " + x3);
        }
        else {
            FuzzyToken inpToken1 = fuzDefuz.fuzzyfie(x1 * w1);
            FuzzyToken inpToken2 = fuzDefuz.fuzzyfie(x2 * w2);
            FuzzyToken[] out = inversor.execute(inpToken1, inpToken2);
            System.out.println("x3 :: " + fuzDefuz.defuzzify(out[0]));
        }

        if ((w1 * x1 - w2 * x2) < -1) {
            x4 = -1;
            System.out.println("x4 :: " + x4);
        }
        else if ((w1 * x1 - w2 * x2) > 1) {
            x4 = 1;
            System.out.println("x4 :: " + x4);
        }
        else {
            FuzzyToken inpToken1 = fuzDefuz.fuzzyfie(x1 * w1);
            FuzzyToken inpToken2 = fuzDefuz.fuzzyfie(-(x2 * w2));
            FuzzyToken[] out = inversor.execute(inpToken1, inpToken2);
            System.out.println("x4 :: " + fuzDefuz.defuzzify(out[1]));
        }
    }
}
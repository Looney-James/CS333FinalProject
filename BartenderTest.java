import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BartenderTest {
    // Unit tests
    @Test
    public void testMain() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));

        Bartender.main(new String[] {});

        String actualOutput = outContent.toString().trim();
        String expectedOutput = "Bourban, Bitters, Bitters, Cherry, Lime 162 calories\r\n" +
                "Vodka, Lime Juice, Lime 40 calories\r\n" +
                "Bourban, Vermouth, Vermouth, Cherry, Bitters 220 calories\r\n" +
                "Gin, Lime Juice, Lime Juice, Sugar, Sugar, Lime 688 calories\r\n" +
                "Highest calorie drink: Tom Collins - 688 calories.\r\n" +
                "Lowest calorie drink: Vodka Gimlet - 40 calories.";

        assertEquals(expectedOutput, actualOutput);

    }

    @Test
    public void testManhattan() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        Bartender.main(new String[] {});

        outContent.reset();
        System.setOut(new PrintStream(outContent));
        Liquor Manhattan = new Bourban();
        Manhattan = new Vermouth(Manhattan);
        Manhattan = new Vermouth(Manhattan);
        Manhattan = new Cherry(Manhattan);
        Manhattan = new Bitters(Manhattan);
        System.out.println(Manhattan.getDescription() + " " + Manhattan.calories() + " calories");

        String actualOutput = outContent.toString().trim();
        String expectedOutput = "Bourban, Vermouth, Vermouth, Cherry, Bitters 220 calories";

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testTomCollins() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        Bartender.main(new String[] {});

        outContent.reset();
        System.setOut(new PrintStream(outContent));
        Liquor TomCollins = new Gin();
        TomCollins = new LimeJuice(TomCollins);
        TomCollins = new LimeJuice(TomCollins);
        TomCollins = new Sugar(TomCollins);
        TomCollins = new Sugar(TomCollins);
        TomCollins = new Lime(TomCollins);
        System.out.println(TomCollins.getDescription() + " " + TomCollins.calories() + " calories");

        String actualOutput = outContent.toString().trim();
        String expectedOutput = "Gin, Lime Juice, Lime Juice, Sugar, Sugar, Lime 688 calories";

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testVodkaGimlet() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        Bartender.main(new String[] {});

        outContent.reset();
        System.setOut(new PrintStream(outContent));
        Liquor VodkaGimlet = new Vodka();
        VodkaGimlet = new LimeJuice(VodkaGimlet);
        VodkaGimlet = new Lime(VodkaGimlet);
        System.out.println(VodkaGimlet.getDescription() + " " + VodkaGimlet.calories() + " calories");

        String actualOutput = outContent.toString().trim();
        String expectedOutput = "Vodka, Lime Juice, Lime 40 calories";

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testOldFashionBranch() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        Bartender.main(new String[] {});

        outContent.reset();
        Liquor OldFashioned = new Bourban();
        OldFashioned = new Bitters(OldFashioned);
        OldFashioned = new Bitters(OldFashioned);
        OldFashioned = new Cherry(OldFashioned);
        OldFashioned = new Lime(OldFashioned);
        System.out.println(OldFashioned.getDescription() + " " + OldFashioned.calories() + " calories");
    }

    @Test
    public void testGetDescription() {
        Liquor drink = new Gin();
        String description = drink.getDescription();
        assertEquals("Gin", description);

        drink = new LimeJuice(drink);
        description = drink.getDescription();
        assertEquals("Gin, Lime Juice", description);

        drink = new Sugar(drink);
        description = drink.getDescription();
        assertEquals("Gin, Lime Juice, Sugar", description);

        drink = new LimeJuice(drink);
        description = drink.getDescription();
        assertEquals("Gin, Lime Juice, Sugar, Lime Juice", description);

        drink = new Lime(drink);
        description = drink.getDescription();
        assertEquals("Gin, Lime Juice, Sugar, Lime Juice, Lime", description);
    }

    @Test
    public void testVodkaGimletEgdge() {
        Liquor VodkaGimlet = new Vodka();
        VodkaGimlet = new LimeJuice(VodkaGimlet);
        System.out.println(VodkaGimlet.getDescription() + " " + VodkaGimlet.calories() + " calories");
    }

    @Test
    public void testCalories() {
        Liquor OldFashioned = new Bourban();
        OldFashioned = new Bitters(OldFashioned);
        OldFashioned = new Bitters(OldFashioned);
        OldFashioned = new Cherry(OldFashioned);
        OldFashioned = new Lime(OldFashioned);
        assert (OldFashioned.calories() >= 0);

        Liquor VodkaGimlet = new Vodka();
        VodkaGimlet = new LimeJuice(VodkaGimlet);
        VodkaGimlet = new Lime(VodkaGimlet);
        assert (VodkaGimlet.calories() >= 0);

        Liquor Manhattan = new Bourban();
        Manhattan = new Vermouth(Manhattan);
        Manhattan = new Vermouth(Manhattan);
        Manhattan = new Cherry(Manhattan);
        Manhattan = new Bitters(Manhattan);
        assert (Manhattan.calories() >= 0);

        Liquor TomCollins = new Gin();
        TomCollins = new LimeJuice(TomCollins);
        TomCollins = new LimeJuice(TomCollins);
        TomCollins = new Sugar(TomCollins);
        TomCollins = new Sugar(TomCollins);
        TomCollins = new Lime(TomCollins);
        assert (TomCollins.calories() >= 0);
    }

    @Test
    public void testLowestCalories() {

        Liquor OldFashioned = new Bourban();
        OldFashioned = new Bitters(OldFashioned);
        OldFashioned = new Bitters(OldFashioned);
        OldFashioned = new Cherry(OldFashioned);
        OldFashioned = new Lime(OldFashioned);

        Liquor VodkaGimlet = new Vodka();
        VodkaGimlet = new LimeJuice(VodkaGimlet);
        VodkaGimlet = new Lime(VodkaGimlet);

        Liquor Manhattan = new Bourban();
        Manhattan = new Vermouth(Manhattan);
        Manhattan = new Vermouth(Manhattan);
        Manhattan = new Cherry(Manhattan);
        Manhattan = new Bitters(Manhattan);

        Liquor TomCollins = new Gin();
        TomCollins = new LimeJuice(TomCollins);
        TomCollins = new LimeJuice(TomCollins);
        TomCollins = new Sugar(TomCollins);
        TomCollins = new Sugar(TomCollins);
        TomCollins = new Lime(TomCollins);

        int OldFashionedCalories = OldFashioned.calories();
        int VodkaGimletCalories = VodkaGimlet.calories();
        int ManhattanCalories = Manhattan.calories();
        int TomCollinsCalories = TomCollins.calories();

        int maxCalories = 0;
        int minCalories = Integer.MAX_VALUE;

        if (OldFashionedCalories > maxCalories) {
            maxCalories = OldFashionedCalories;
        }
        if (VodkaGimletCalories > maxCalories) {
            maxCalories = VodkaGimletCalories;
        }
        if (ManhattanCalories > maxCalories) {
            maxCalories = ManhattanCalories;
        }
        if (TomCollinsCalories > maxCalories) {
            maxCalories = TomCollinsCalories;
        }

        if (OldFashionedCalories < minCalories) {
            minCalories = OldFashionedCalories;
        }
        if (VodkaGimletCalories < minCalories) {
            minCalories = VodkaGimletCalories;
        }
        if (ManhattanCalories < minCalories) {
            minCalories = ManhattanCalories;
        }
        if (TomCollinsCalories < minCalories) {
            minCalories = TomCollinsCalories;
        }
        if (TomCollinsCalories > maxCalories) {
            maxCalories = TomCollinsCalories;
        }

        if (OldFashionedCalories < minCalories) {
            minCalories = OldFashionedCalories;
        }
        if (VodkaGimletCalories < minCalories) {
            minCalories = VodkaGimletCalories;
        }
        if (ManhattanCalories < minCalories) {
            minCalories = ManhattanCalories;
        }
        if (TomCollinsCalories < minCalories) {
            minCalories = TomCollinsCalories;
        }
        assertEquals(minCalories, VodkaGimletCalories);

    }

    // Integration test
    @Test
    public void testBartenderIntegration() {
        String[] args = {};

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Bartender.main(args);

        String output = outContent.toString().trim();

        String expectedOutput = "Bourban, Bitters, Bitters, Cherry, Lime 162 calories\r\n" +
                "Vodka, Lime Juice, Lime 40 calories\r\n" +
                "Bourban, Vermouth, Vermouth, Cherry, Bitters 220 calories\r\n" +
                "Gin, Lime Juice, Lime Juice, Sugar, Sugar, Lime 688 calories\r\n" +
                "Highest calorie drink: Tom Collins - 688 calories.\r\n" +
                "Lowest calorie drink: Vodka Gimlet - 40 calories.";
        assertEquals(expectedOutput, output);
    }

    @Test
    public void testHighestAndLowestCalorieDrinksIntegration() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Bartender.main(new String[] {});

        String actualOutput = outContent.toString().trim();
        String[] lines = actualOutput.split("\\r?\\n");

        // check the highest and lowest calorie drinks
        String highestCalorieDrink = lines[lines.length - 2].split(": ")[1].split(" - ")[0];
        String lowestCalorieDrink = lines[lines.length - 1].split(": ")[1].split(" - ")[0];

        assertEquals("Tom Collins", highestCalorieDrink);
        assertEquals("Vodka Gimlet", lowestCalorieDrink);
    }

    @Test
    public void testOldFashionedIntegration() {
        Liquor oldFashioned = new Bourban();
        oldFashioned = new Bitters(oldFashioned);
        oldFashioned = new Bitters(oldFashioned);
        oldFashioned = new Cherry(oldFashioned);
        oldFashioned = new Lime(oldFashioned);

        assertEquals("Bourban, Bitters, Bitters, Cherry, Lime", oldFashioned.getDescription());
        assertEquals(162, oldFashioned.calories());
    }

    @Test
    public void testVodkaGimletIntegration() {
        Liquor vodkaGimlet = new Vodka();
        vodkaGimlet = new LimeJuice(vodkaGimlet);
        vodkaGimlet = new Lime(vodkaGimlet);

        assertEquals("Vodka, Lime Juice, Lime", vodkaGimlet.getDescription());
        assertEquals(40, vodkaGimlet.calories());
    }

    @Test
    public void testManhattanIntegration() {
        Liquor manhattan = new Bourban();
        manhattan = new Vermouth(manhattan);
        manhattan = new Vermouth(manhattan);
        manhattan = new Cherry(manhattan);
        manhattan = new Bitters(manhattan);

        assertEquals("Bourban, Vermouth, Vermouth, Cherry, Bitters", manhattan.getDescription());
        assertEquals(220, manhattan.calories());
    }
}
package reflectionInvoke;

import org.junit.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class invokes{

    // map: regex pattern, methodName
    HashMap<Pattern, String> regexMethodMap = new HashMap<Pattern, String>();
    Pattern pattern;
    Matcher matcher;
    testPage testPage = new testPage();
    int grups;
    String methodText;

    Properties prop = new Properties();
    Method met;

    //    IN TEST FIELDS
    int rows;
    String element;
    String roundingRuleName;
    String param1, param2, param3;
    boolean test;

    //  PAGES


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
       invokes invoke = new invokes();
       invoke.go();
    }

    public void go() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method met = this.getClass().getMethod("invoker", String.class);
        met.invoke(this, "test string");

        Method metB = testPage.getClass().getMethod("invoker");
        metB.invoke(testPage);

    }

    public void invoker(String str){
        System.out.println("own class invoked method output: " + str);
    }

    void assertion(){
        Assert.assertTrue(false);
    }

    void initSetup(String feature) throws IOException {
        // read all WhenThen annotated methods and put them to MAP: regex, method_name

        Method[] methods = this.getClass().getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(WhenThen.class)) {
                WhenThen methodAnootation = m.getAnnotation(WhenThen.class);
                regexMethodMap.put(Pattern.compile(methodAnootation.value()), m.getName());
//                System.out.println(Pattern.compile(methodAnootation.value()) + " - " + m.getName());
            }
        }

        // load a properties file

        prop.load(new FileInputStream(System.getProperty("user.dir") +  "\\src\\test\\resources\\bdd.test.properties"));

        try (Stream<String> stream = Files.lines(Paths.get(System.getProperty("user.dir") + "\\src\\selenium\\test\\java\\features\\" + feature))) {
            stream.forEach(line -> {
                try {
                    matchMatcher(line);
                } catch (Exception e) {System.out.println("error" + e);}
            });
        }
        assertion();
    }

    public void matchMatcher(String line) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for(HashMap.Entry<Pattern, String> entry : regexMethodMap.entrySet()) {
            Matcher matcher = entry.getKey().matcher(line);
            if (matcher.matches()) {
                invoker(entry.getValue(), entry.getKey().toString(), line);
                break;
            }
        }
    }

    public void invoker(String method, String regex, String line) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        matcher = Pattern.compile(regex).matcher(line);
        grups = matcher.groupCount();

        while (matcher.find()) {
            switch (grups) {
                case 0:
                    Method metA = this.getClass().getMethod(method);
                    metA.invoke(this);
                    break;
                case 1:
                    Method met = this.getClass().getMethod(method, String.class);
                    met.invoke(this, matcher.group(1));
                    break;
                case 2:
                    Method metB = this.getClass().getMethod(method, String.class, String.class);
                    metB.invoke(this, matcher.group(1), matcher.group(2));
                    assertion();
                    break;
                case 3:
                    Method metC = this.getClass().getMethod(method, String.class, String.class, String.class);
                    metC.invoke(this, matcher.group(1), matcher.group(2), matcher.group(3));

            }
        }
    }

    @WhenThen("Set (.*) as (.*)")
    public void setas(String setWhat, String setAs) throws InterruptedException {
        switch (setAs){
            case "timeStamp":
                setAs = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
                break;
            default: break;
        }

        switch (setWhat){
            case "rounding rule name": roundingRuleName = setAs; System.out.println("> Set " + setWhat + " = " + roundingRuleName); break;
            case "param1": param1= setAs; System.out.println("> Set " + setWhat + " = " + setAs); break;
            case "Curve": break;
        }
    }

    @WhenThen("I am on (\\w*.*\\w*) page")
    public void IamOnPage(String page) throws InterruptedException {
        switch (String.valueOf(page)){
            case "Rounding Rule":

                break;
            case "Strategies":
                break;
            case "Curve":
//                testPage = curveDefinitionPage.initElements(PricingToolTest.driver, curveDefinitionPage.class);
        }
//        System.out.println(String.valueOf("> BDD page is now: " + testPage.getClass().getSimpleName()));
    }

    @WhenThen("I click ([\\w\\s]+) button")
    public void clicks(String button) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InterruptedException {
        System.out.println("> Click: " + button);
        prop.forEach((key, value) -> {
            if(value.toString().equals(button))
                methodText = String.valueOf(key);
            return;
        });

        System.out.println("method: " + testPage.getClass().getSimpleName() + "->" + methodText);

        switch (button) {
            case "Exceptions":
                met = testPage.getClass().getMethod("addButtonClick", String.class);
                met.invoke(testPage, 10);
                break;
            default:
                met = testPage.getClass().getMethod(methodText);
                met.invoke(testPage);
        }
    }

    @WhenThen("I select (.*) from (.*) list")
    public void selectPosition(String position, String list) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InterruptedException {
        System.out.println("> Select: " + position + " from: " + list);

        met = testPage.getClass().getMethod(list + "SelectBy", String.class);
        met.invoke(testPage, position);
    }

    @WhenThen("Wait ([\\d]+)")
    public void wait(String seconds) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InterruptedException {
        System.out.println("> Wait " + Long.parseLong(seconds) * 1000 + "ms");
        Thread.sleep(Long.parseLong(seconds) * 1000);
    }

    @WhenThen("On dashboard I click (.*) link")
    public void dashboardlink(String link){
//        assertionPage ase = new assertionPage();
//        ase.assrt(false);
        System.out.println(" === X === ");
        assertion();
    }

    @WhenThen("I count ([a-z]*)")
    public void count(String countWhat) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InterruptedException {
        System.out.println("> COUNT " + countWhat);
        Method met = testPage.getClass().getMethod("getGridRowsCount");
        rows = (int) met.invoke(testPage);
        System.out.println("rowz: " + rows);
    }

    @WhenThen("I enter (.*) and [\"](.*)[\"] in (.*)")
    public void enterTextAndParam(String param, String text, String inputName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InterruptedException {
        prop.forEach((key, value) -> {
                    if(value.toString().equals(inputName))
                        methodText = String.valueOf(key);
                    return;
                }
        );

        Method met = testPage.getClass().getMethod(methodText, String.class);

        switch(param) {
            case "param1": System.out.println("> Enter: " + param1 +  text + " in " + methodText); met.invoke(testPage, text + param1); break;
            default: System.out.println("param not found: " + param); met.invoke(testPage, text);
        }
    }

    @WhenThen("I enter [\"](.*)[\"] in (.*)")
    public void enterText(String text, String inputName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        prop.forEach((key, value) -> {
            if(value.toString().equals(inputName))
                methodText = String.valueOf(key);
            return;
        });

        System.out.println("> Enter: " + text + " in " + methodText);
        Method met = testPage.getClass().getMethod(methodText, String.class);
        met.invoke(testPage, text);

    }

    @WhenThen("Then (.*) element is displayed")
    public void elementDisplayed(String element) throws InvocationTargetException, IllegalAccessException, InterruptedException, NoSuchMethodException, InstantiationException {
        switch (element) {
            case "Rounding rules popup":
                element = "popupDisplayed";
                break;
            case "Curve":
//                testPage = curveDefinitionPage.initElements(PricingToolTest.driver, curveDefinitionPage.class);
        }

        this.test = false;
        Method met = null;

        met = testPage.getClass().getMethod(element);
        boolean y = (Boolean) met.invoke(testPage);
        invokes.this.testz(this.test);
        Assert.assertTrue(test);
        testz((Boolean) met.invoke(testPage));
        Assert.assertFalse((Boolean) met.invoke(testPage));
        Assert.assertTrue(false);
        assert(false);
        Thread.sleep(5000);
    }

    public void testz(boolean b){
        Assert.assertTrue(b);
    }

    public void pagezOld(String patternString, String lineString) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InterruptedException {
        pattern = Pattern.compile(patternString);
        matcher = pattern.matcher(lineString);
        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            result.append(matcher.group(1));
        }
        System.out.println(String.valueOf(result));

//        testPage = roundingRulesPage.initElements(PricingToolTest.driver, roundingRulesPage.class);

        Thread.sleep(250);

//System.out.println(String.valueOf(testPage.getClass()).substring("acceptance.pageObjects.pages.roundingRules.roundingRulesPage".lastIndexOf("."), "acceptance.pageObjects.pages.roundingRules.roundingRulesPage".length()));
//        Method metz = testPage.getClass().getMethod("addButtonClick");
//        metz.invoke(testPage);
//        Thread.sleep(2500);
    }

    public void clickz() throws InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        testPage = roundingRulesPage.initElements(PricingToolTest.driver, roundingRulesPage.class);

        Thread.sleep(250);

        Method metz = testPage.getClass().getMethod("addButtonClick");
        metz.invoke(testPage);
        Thread.sleep(2500);
    }

    public void snippets(){

        // get the property value and print it out
//        System.out.println(prop.getProperty("alex"));
////            System.out.println(prop.getProperty("alex"));
//        prop.forEach((key, value) -> {
//                    System.out.println(key + " = " + String.valueOf(value));
//                    if(value.toString().equals("3"))
//                        System.out.println(String.valueOf("3 => " + key));
//                    else System.out.println("prop not found");
//                }
//        );
//            prop.forEach((key, value) -> System.out.println(value.toString().equals("---123--- si inca ceva") ? key.toString() : "property not found"));


        /*roundingRules.addButtonClick();

        System.out.println("Check popup");
        Assert.assertTrue(roundingRules.popupDisplayed());
        Assert.assertEquals(roundingRules.titleText(), "Create Rounding Rule");

        System.out.println("Step: Fill in all fields");

        roundingRules.ruleNameInputEnterText(roundingRuleName);

        roundingRules.inputEnterText(roundingRulesPage.Elements.GT, "10");
        roundingRules.inputEnterText(roundingRulesPage.Elements.LE, "10");
        roundingRules.inputEnterText(roundingRulesPage.Elements.SCHEMA, "{}");

        roundingRules.buttonClick(roundingRulesPage.Elements.ADD_STEP);
        Thread.sleep(100);

        roundingRules.buttonClick(roundingRulesPage.Elements.SAVE_BUTTON);

        logger.debug("Save current date & time first");
        String timeStamp = new SimpleDateFormat("MMM d yyyy, HH:mm").format(Calendar.getInstance().getTime());
        roundingRules.waitForPageContentReady();

        System.out.println("Step: Rounding rule displayed in the grid");
        Assert.assertEquals(roundingRules.getColumnValueForCurveNameRow(roundingRuleName, roundingRulesPage.ColumnNames.RULE_NAME), roundingRuleName);
        Assert.assertEquals(roundingRules.getColumnValueForCurveNameRow(roundingRuleName, roundingRulesPage.ColumnNames.MODIFIED_ON), timeStamp);
        Assert.assertEquals(roundingRules.getGridRowsCount(), rowz + 1);
        */
    }

/*
    public void invokerOld(String method, String regex, String line) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        System.out.println("Method: ---> " + method);
        Method met = this.getClass().getMethod(method, String.class, String.class);
        met.invoke(this, regex, line);
    }
*/

    public void getGridRowsCount() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method met = testPage.getClass().getMethod("getGridRowsCount");
        int rowz = (int) met.invoke(testPage);
        System.out.println(String.valueOf(rowz));
    }

    public void createRoundingRulesPage(){
//        testPage = roundingRulesPage.initElements(PricingToolTest.driver, roundingRulesPage.class);
    }
}

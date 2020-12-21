import java.util.ArrayList;

public interface StringMethodExtraInterfaces
{
    static String nextOSFolder = "\\";
    static String thisFolder = "src";
    static String thisClass = "StringMethodExtraInterfaces";
    static String fullClassPathCollective = thisFolder + nextOSFolder + thisClass + nextOSFolder;
    static String tabular1 = "    ";
    static String tabular2 = tabular1 + tabular1;
    static String tabular3 = tabular2 + tabular1;


    public static String[][] simplifyRequestedFileContents(String fullContent, int startIndex, int endIndex, boolean seeExecutionInfoInTerminal)
    {
        String thisMethod = "simplifyRequestedFileContents";
        if(seeExecutionInfoInTerminal)
        {
            System.out.println("Start method: " + fullClassPathCollective + thisMethod);
        }


        int
            lineLoops ,
            lineLoopsToLines ,
            approvedLineLoops;

        String
            userFilePath ,
            fullUserFileContentsSingleString ,
            temporaryUserFileContentsSingleString ,
            subString1 ,
            subString2 ,
            subString3;

        String[][]
            userFileContentsHolder ,
            userFileContentsFinal ,
            lastCorrectChecker;

        ArrayList<Object>
            finalResultReader ,
            finalResultSender ,
            temporarySubstringHolder;

        Boolean
            fileReadResult;

        boolean
            countLine;



        String[][]
            resultsToReturn;

        String
            localFullContent ,
                localFullContentTempLine;

        int
                arrayFields;




        localFullContent = fullContent;

        lineLoops = StringMethodInterfaces.countTotalNumberOfLines(localFullContent, seeExecutionInfoInTerminal);
        lineLoopsToLines = lineLoops + 1;

        if(seeExecutionInfoInTerminal)
        {
            System.out.println(tabular1 + "lineLoops = " + lineLoops);
            System.out.println(tabular1 + "lineLoopsToLines = " + lineLoopsToLines);
        }


        userFileContentsHolder = new String[lineLoops][3];
        arrayFields = 0;
        for(int i = 1; i < lineLoopsToLines; i++)
        {
            temporarySubstringHolder = StringMethodInterfaces.returnFullLineByStringLineIndex(localFullContent , i , seeExecutionInfoInTerminal);

            if(seeExecutionInfoInTerminal)
            {
                System.out.println(tabular1 + "temporarySubstringHolder: " + "\n" + "$" + temporarySubstringHolder + "$");
            }


            countLine = (boolean) temporarySubstringHolder.get(0);

            if(countLine)
            {
                if(seeExecutionInfoInTerminal)
                {
                    System.out.println(tabular1 + "countLine is true, adding elements to String[][] begins.");
                }


                localFullContentTempLine = (String) temporarySubstringHolder.get(2);

                if(seeExecutionInfoInTerminal)
                {
                    System.out.println(tabular2 + "baseFileTempLine: " + "\n" + "$" + baseFileTempLine + "$");
                }


                subString1 = StringMethodInterfaces.returnSubstringByLine(baseFileTempLine , 0 ,
                        seeExecutionInfoInTerminal);

                if(seeExecutionInfoInTerminal)
                {
                    System.out.println(tabular2 + "baseFileSubstring11: " + "\n" + "$" + subString1 + "$");
                }


                subString2 = StringMethodInterfaces.returnSubstringByLine(baseFileTempLine , 1 ,
                        seeExecutionInfoInTerminal);

                if(seeExecutionInfoInTerminal)
                {
                    System.out.println(tabular2 + "baseFileSubstring2: " + "\n" + "$" + subString2 + "$");
                }

                subString3 = StringMethodInterfaces.returnSubstringByLine(baseFileTempLine , 2 ,
                        seeExecutionInfoInTerminal);

                if(seeExecutionInfoInTerminal)
                {
                    System.out.println(tabular2 + "baseFileSubstring3: " + "\n" + "$" + subString3 + "$");
                }


                userFileContentsHolder[arrayFields][0] = subString1;
                userFileContentsHolder[arrayFields][1] = subString2;
                userFileContentsHolder[arrayFields][2] = subString3;

                if(seeExecutionInfoInTerminal)
                {
                    System.out.println(tabular2 + "userFileContentsHolder[" + arrayFields + "][0]: " + "\n" + "$" + userFileContentsHolder[arrayFields][0] + "$");
                    System.out.println(tabular2 + "userFileContentsHolder[" + arrayFields + "][1]: " + "\n" + "$" + userFileContentsHolder[arrayFields][1] + "$");
                    System.out.println(tabular2 + "userFileContentsHolder[" + arrayFields + "][1]: " + "\n" + "$" + userFileContentsHolder[arrayFields][2] + "$");
                }


                ++arrayFields;

            }

        }

        if(seeExecutionInfoInTerminal)
        {
            System.out.println(tabular1 + "arrayFields = " + arrayFields);
        }


        resultsToReturn = new String[arrayFields][3];
        for(int i = 0; i < arrayFields; i++)
        {
            if(seeExecutionInfoInTerminal)
            {
                System.out.println(tabular2 + "Strings being saved loop " + i + ".");
            }


            resultsToReturn[i][0] = userFileContentsHolder[i][0];
            resultsToReturn[i][1] = userFileContentsHolder[i][1];
            resultsToReturn[i][2] = userFileContentsHolder[i][2];

        }


        if(seeExecutionInfoInTerminal)
        {
            System.out.println(tabular1 + "resultsToReturn.length = " + resultsToReturn.length);


            for(int i = 0; i < resultsToReturn.length; i++)
            {
                System.out.println(tabular2 + "resultsToReturn[" + i + "][0] = " + resultsToReturn[i][0]);
                System.out.println(tabular2 + "resultsToReturn[" + i + "][1] = " + resultsToReturn[i][1]);
                System.out.println(tabular2 + "resultsToReturn[" + i + "][2] = " + resultsToReturn[i][2]);
            }

        }

        if(seeExecutionInfoInTerminal)
        {
            System.out.println("End method: " + fullClassPathCollective + thisMethod);
        }


        return resultsToReturn;









    }


}

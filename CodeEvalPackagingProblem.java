//Problem Statement
/**
 * You want to send your friend a package with different things.
 Each thing you put inside the package has such parameters as index number, weight and cost.
 The package has a weight limit.
 Your goal is to determine which things to put into the package so that the total weight is less than or equal to the package limit and the total cost is as large as possible.
 You would prefer to send a package which weights less in case there is more than one package with the same price.

 INPUT SAMPLE:

 Your program should accept as its first argument a path to a filename. The input file contains several lines. Each line is one test case.

 Each line contains the weight that the package can take (before the colon) and the list of things you need to choose.
 Each thing is enclosed in parentheses where the 1st number is a thing's index number, the 2nd is its weight and the 3rd is its cost. E.g.
 <EOF>
 81 : (1,53.38,$45) (2,88.62,$98) (3,78.48,$3) (4,72.30,$76) (5,30.18,$9) (6,46.34,$48)
 8 : (1,15.3,$34)
 75 : (1,85.31,$29) (2,14.55,$74) (3,3.98,$16) (4,26.24,$55) (5,63.69,$52) (6,76.25,$75) (7,60.02,$74) (8,93.18,$35) (9,89.95,$78)
 56 : (1,90.72,$13) (2,33.80,$40) (3,43.15,$10) (4,37.97,$16) (5,46.81,$36) (6,48.77,$79) (7,81.80,$45) (8,19.36,$79) (9,6.76,$64)
 </EOF>

 OUTPUT SAMPLE:

 For each set of things that you put into the package provide a list (items’ index numbers are separated by comma). E.g.
 <Output>
 4
 -
 2,7
 8,9
 </Output>

 CONSTRAINTS:
 Max weight that a package can take is ≤ 100
 There might be up to 15 items you need to choose from
 Max weight and cost of an item is ≤ 100
 */

package com.whatfix;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class CodeEvalPackagingProblem {


    public static void main(String[] args) {

        CodeEvalPackagingProblem pp = new CodeEvalPackagingProblem();
        if (args.length != 1) {
            System.err.println("no file specified!!");
        } else {
            pp.package_solution(args[0]);
        }
    }

    private final void package_solution(final String path) {

        final String comma = ",";

        final Pattern colon_pattern = Pattern.compile(":");
        final Pattern braces_pattern = Pattern.compile("\\)\\(");
        final Pattern comma_pattern = Pattern.compile(comma);

        final String open_Brace = "(";
        final String close_Brace = ")";

        final String empty = "";
        final String white_space = " ";
        final String dollar_sign = "$";
        final String hyphen = "-";


        final int[] emptyIntAr = new int[0];

        try {
            int iSize;
            int packageMaxWeight;

            List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);

            for (String line : lines) {
                if (line.length() == 0) {
                    continue;
                }
                line = line.replace(white_space, empty);
                String[] packline = colon_pattern.split(line, 0);
                packageMaxWeight = Integer.valueOf(packline[0]);
                if (packageMaxWeight > 100) {
                    continue;
                }
                String[] sItems = braces_pattern.split(packline[1], 0);

                int sLength = sItems.length;

                List<Item> items = new ArrayList<>(sLength);

                for (int i = 0; i < sLength; i++) {
                    String sItem = sItems[i].replace(open_Brace, empty);
                    sItem = sItem.replace(close_Brace, empty);
                    String[] itemData = comma_pattern.split(sItem, 0);

                    final float weight = Float.valueOf(itemData[1]);

                    if (weight <= packageMaxWeight) {
                        Item item = new Item();
                        item.index = Integer.valueOf(itemData[0]);
                        item.weight = weight;
                        item.cost = Integer.valueOf(itemData[2].replace(dollar_sign, empty));
                        items.add(item);
                    }
                }
                Collections.sort(items);

                iSize = items.size();
                int maxCost = 0;
                float maxWeight = packageMaxWeight;

                int[] cPack = emptyIntAr;
                int cPacked = 0;
                for (int i = 0; i < iSize; i++) {
                    for (int j = i; j < iSize; j++) {

                        int currentCost = 0;
                        float currentWeight = 0;
                        int[] pack = new int[15];
                        int packed = 0;

                        final Item item1 = items.get(j);
                        if ((currentWeight + item1.weight) <= packageMaxWeight) {
                            pack[item1.index] = 1;
                            currentCost += item1.cost;
                            currentWeight += item1.weight;
                            packed++;
                        }

                        for (int k = i; k < iSize; k++) {
                            if (k != j) {
                                final Item item = items.get(k);
                                if ((currentWeight + item.weight) <= packageMaxWeight) {
                                    pack[item.index] = 1;
                                    currentCost += item.cost;
                                    currentWeight += item.weight;
                                    packed++;
                                }
                            }
                        }
                        if (packed > 0 && (currentCost > maxCost || (currentCost == maxCost && currentWeight < maxWeight))) {
                            maxCost = currentCost;
                            maxWeight = currentWeight;
                            cPack = pack;
                            cPacked = packed;
                        }
                    }
                }
                if (cPacked > 0) {
                    final StringBuilder sb = new StringBuilder(cPacked * 2);
                    int j = 0;
                    for (int i = 1; i < 15; i++) {
                        if (cPack[i] == 1) {
                            sb.append(i);
                            j++;
                            if (j < cPacked) {
                                sb.append(comma);
                            } else {
                                break;
                            }
                        }
                    }
                    System.out.println(sb.toString());
                } else {
                    System.out.println(hyphen);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(CodeEvalPackagingProblem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    final class Item implements Comparable<Item> {
        int index;
        float weight;
        int cost;


        @Override
        public String toString() {
            return "Item{" +
                    "index=" + index +
                    ", weight=" + weight +
                    ", cost=" + cost +
                    '}';
        }

        @Override
        public int compareTo(final Item o) {
            if (cost == o.cost) {
                return weight > o.weight ? 1 : -1;
            } else {
                return cost < o.cost ? 1 : -1;
            }
        }
    }
}

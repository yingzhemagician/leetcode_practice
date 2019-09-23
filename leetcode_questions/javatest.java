import java.util.*;



 class Solution{

    private static List<String> generatePhrases(List<String> inputs) {
        List<String> result = new ArrayList<>();
        Map<String, List<Integer>> firstWordMap = new HashMap<>();
        for(int i=0; i<inputs.size(); ++i) {
            String str = inputs.get(i);
            String firstWord = str.substring(0, str.indexOf(' '));
            firstWordMap.putIfAbsent(firstWord, new ArrayList<>());
            firstWordMap.get(firstWord).add(i);
        }

        for(int i=0; i<inputs.size(); ++i) {
            String str = inputs.get(i);
            String lastWord = str.substring(str.lastIndexOf(' ') + 1);
            if(firstWordMap.containsKey(lastWord)) {
                List<Integer> indexes = firstWordMap.get(lastWord);
                for(Integer index : indexes) {
                    if(i != index) {
                        String temp = inputs.get(index);
                        result.add(str + temp.substring(temp.indexOf(' ')));
                    }
                }
            }
        }
        return result;
    }

    private static List<String> generate_phrases(List<String> phrases) {
        List<Phrase> phraseList = generatePhraseList(phrases);
        Map<String, List<Phrase>> map = generateHashMapOfUniqueKeys(phraseList);
        return generateOutputList(map);
    }

    private static List<Phrase> generatePhraseList(List<String> phrases) {
        List<Phrase> phraseList = new ArrayList<>();
        for (String p: phrases) {
            Phrase temp = new Phrase(p);
            phraseList.add(temp);
        }
        return phraseList;
    }

    private static Map<String, List<Phrase>> generateHashMapOfUniqueKeys(List<Phrase> phraseList) {
        Map<String, List<Phrase>> map = new HashMap<>();
        for(Phrase p : phraseList) {
            String start = p.getStart();
            if(!map.containsKey(start)) {
                List<Phrase> temp = new ArrayList<>();
                temp.add(p);
                map.put(start, temp);
            } else {
                map.get(start).add(p);
            }
        }
        return map;
    }

    private static List<String> generateOutputList(Map<String, List<Phrase>> map) {
        List<String> output = new ArrayList<>();
        for(List<Phrase> list: map.values()) {
            for(Phrase p: list) {
                String keyToBeSearched = p.getEnd();
                if(map.containsKey(keyToBeSearched)) {
                    List<Phrase> temp = map.get(keyToBeSearched);
                    for(Phrase p2: temp) {
                        output.add(p.getWhole()+" "+p2.getMiddle());
                    }
                }
            }
        }
        return output;
    }

    static class Phrase {
        private final String start;
        private final String middle;
        private final String end;
        private final String whole;

        public Phrase(String initial) {
            this.whole = initial;
            String[] words = initial.split(" ");
            this.start = words[0];
            this.middle = Arrays.stream(words, 1, words.length).collect(joining(" "));
            this.end = words[words.length - 1];
        }

        public String getStart() {return this.start;}
        public String getMiddle() {return this.middle;}
        public String getEnd() {return this.end;}
        public String getWhole() {return this.whole;}
    }
     public static void main(String[] args) {
        List<String> inputs = new ArrayList<String>(Arrays.asList("mission statement", "a quick bite to eat",
        "a chip off the old block",
        "chocolate bar",
        "mission impossible",
        "a man on a mission",
        "block party",
        "eat my words",
        "bar of soap"));

         List<String> outputs =  generate_phrases(inputs);

         for(String str : outputs){
             System.out.println(str);
         }

     }
 }




public class SubStringService {
    public int findSubString(String mainString, String subString){
        if(mainString == null){
            return -1;
        }
        else if (mainString.isEmpty()){
            return -1;
        }
        if(subString == null){
            return -1;
        }
        else if (subString.isEmpty()){
            return -1;
        }

        if (subString.length() > mainString.length()){
            return -1;
        }
        String mainLower = mainString.toLowerCase().trim();
        String subLower = subString.toLowerCase().trim();

        return mainLower.indexOf(subLower);
    }
}

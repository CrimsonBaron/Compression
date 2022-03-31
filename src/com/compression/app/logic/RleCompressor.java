package com.compression.app.logic;

public class RleCompressor implements Compressor {
    public RleCompressor() {
    }

    @Override
    public String encode(String s) {
        int count = 1;
        char[] chars = s.toCharArray();

        String compressedResult = "";

        for (int i = 1; i < chars.length ; i++) {
            if (chars[i] == chars[i-1]){
                count++;
            }else{
                compressedResult += count +""+chars[i-1];
                count = 1;
            }
            if (i == chars.length-1){
                compressedResult += count +""+chars[i-1];
            }
        }
        return compressedResult;
    }

    private int findLetterIndex(char[] arr, int start){
        int index = 0;
        for (int i = start; i < arr.length ; i++) {
            if (!Character.isDigit(arr[i])){
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public String decode(String s) {
        String decodedString = "";
        char[] chars = s.toCharArray();
        int prevIndex=0;
        for (int i = 0; i < chars.length ; i+=2) {
            String numberes = "";
            int endIndex = findLetterIndex(chars, prevIndex);
            for (int j = prevIndex; j <endIndex ; j++) {
                numberes += ""+chars[j];
            }

            if (numberes.equals("")){
                return decodedString;
            }

            int n = Integer.parseInt(numberes);
            for (int j = 0; j < n ; j++) {
                decodedString += ""+ chars[endIndex];
            }
            prevIndex = endIndex+1;
        }
        return decodedString;
    }
}

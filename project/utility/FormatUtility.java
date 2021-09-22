package edu.citytech.cst.project.utility;

import java.text.DecimalFormat;

public class FormatUtility {

   /*
      Examples 
      customFormat("###,###.###", 123456.789);
      customFormat("###.##", 123456.789);
      customFormat("000000.000", 123.78);
      customFormat("$###,###.###", 12345.67);  

   */

   static public  String customFormat(String pattern, Number value ) {
      DecimalFormat myFormatter = new DecimalFormat(pattern);
      String output = myFormatter.format(value);
      return output;
   }   
}
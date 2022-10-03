package com.collectors;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class JavaCollectAndThen {

	public static void main(String[] args) {
		
        var vals = List.of(230, 210, 120, 250, 300);

        var avgPrice = vals.stream()
        		.collect(Collectors.collectingAndThen(Collectors.averagingInt(e -> e),
                avg -> {
                    var nf = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
                    return nf.format(avg);
                })
        );

        System.out.printf("The average price is %s%n", avgPrice);
        
	}

}

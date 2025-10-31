package portfolio.caio.bookstore.model.interfaces;

import java.math.BigDecimal;

import portfolio.caio.bookstore.infrastructure.entity.sallablebook.SallableBook;

public interface Sallable {

	BigDecimal tenPercentDiscount = BigDecimal.valueOf(0.1);
	
	default BigDecimal getTenPercentDiscount(BigDecimal price) {
		return price.subtract(price.multiply(tenPercentDiscount));
	}
	
	default BigDecimal customDiscount(BigDecimal totalPrice, BigDecimal discount) {
		return totalPrice.subtract(totalPrice.multiply(discount.divide(BigDecimal.valueOf(100))));
	}
	
	default String sell(SallableBook sallableBook, Integer units) {
		Integer remainingUnits = sallableBook.getUnits() - units;
		if(remainingUnits >= 0) {
			sallableBook.setUnits(remainingUnits);
			BigDecimal totalToPay = sallableBook.getPrice().multiply(BigDecimal.valueOf(units));
			return "Total a pagar por '"+units+"' unidades: R$"+totalToPay;
		}
		if(sallableBook.getUnits() > 0) return "Temos apenas "+sallableBook.getUnits()+" disponíveis";
		return "Não há unidades disponíveis no momento";
	}
}

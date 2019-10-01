package profiles.additionally;

import java.util.ArrayList;
import java.util.List;

import profiles.Food;
import profiles.FoodProviderService;

public class FoodProviderServiceImpl implements FoodProviderService {

	@Override
	public List<Food> provideLunchSet() {
		// TODO Auto-generated method stub
		List<Food> lunchSet = new ArrayList<Food>();
		lunchSet.add(new Food("Coke"));
		lunchSet.add(new Food("Hamburger"));
		lunchSet.add(new Food("French Fries"));

		return lunchSet;
	}

}

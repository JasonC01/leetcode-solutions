class FoodRatings {
        HashMap<String, PriorityQueue<String[]>> cuisinesMap;
        HashMap<String, Integer> ratingsMap;
        HashMap<String, String> foodToCuisineMap;
        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            cuisinesMap = new HashMap<>();
            ratingsMap = new HashMap<>();
            foodToCuisineMap = new HashMap<>();
            for (int i = 0; i < foods.length; i++) {
                String currentFood = foods[i];
                String cuisine = cuisines[i];
                int rating = ratings[i];
                ratingsMap.put(currentFood, rating);
                foodToCuisineMap.put(currentFood, cuisine);
                if (!cuisinesMap.containsKey(cuisine)) {
                    cuisinesMap.put(cuisine, new PriorityQueue<>((a, b) -> {
                        int ratingA = Integer.parseInt(a[1]);
                        int ratingB = Integer.parseInt(b[1]);
                        if (ratingA == ratingB) {
                            return a[0].compareTo(b[0]);
                        } else {
                            return Integer.compare(ratingB, ratingA);
                        }
                    }));
                }
                cuisinesMap.get(cuisine).add(new String[]{currentFood, String.valueOf(rating)});
            }
        }

        public void changeRating(String food, int newRating) {
            ratingsMap.put(food, newRating);
            cuisinesMap.get(foodToCuisineMap.get(food)).add(new String[]{food, String.valueOf(newRating)});
        }

        public String highestRated(String cuisine) {
            while (!cuisinesMap.get(cuisine).peek()[1].equals(String.valueOf(ratingsMap.get(cuisinesMap.get(cuisine).peek()[0])))) {
                cuisinesMap.get(cuisine).poll();
            }
            return cuisinesMap.get(cuisine).peek()[0];
        }
    }
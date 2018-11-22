public static double[][] multiply(double[][] a, double[][] b) {
      int m1 = a.length;
      int n1 = a[0].length;

      int m2 = b.length;
      int n2 = b[0].length;
      //if (n1 != m2) throw new RuntimeException("Illegal matrix dimensions.");
      double[][] c = new double[m1][n2];
      for (int i = 0; i < m1; i++)
          for (int j = 0; j < n2; j++)
              for (int k = 0; k < n1; k++)
                  c[i][j] += a[i][k] * b[k][j];
      return c;
  }



public int[][] mutiplple(int[][] a, int[][] b){
  int m1 = a.length;
  int n1 = a[0].legnth;
  int m2 = b.length;
  int n2 = b[0].lnegt;
  int[][] res = new int[m1][n2];
  for(int i = 0; i < m1; i++){

    for(int j = 0; j < n2; j++){

      for(int k = 0; k < n1; k++){
        c[i][j] += a[i][k] * b[k][j];
      }
    }
  }
}


Step 3, Implement searchItems() and saveItem() in MongoDBConnection.

Checkthe find and insertOne syntax, how could you construct your query and translate it into Java code?
db.items.find(
  {
    “item_id”: “abcd”
  }
)
db.items.insertOne(
  {
    “Item_id”: “1234”,
    “Name”: “abcd”,
    “Rating”: 4,
    ….
  }
)

@Override
	public void saveItem(Item item) {
		if (db == null) {
			return;
		}
		FindIterable<Document> iterable = db.getCollection("items").find(eq("item_id", item.getItemId()));
		if (iterable.first() == null) {
			db.getCollection("items")
					.insertOne(new Document().append("item_id", item.getItemId()).append("name", item.getName())
							.append("rating", item.getRating()).append("address", item.getAddress())
							.append("image_url", item.getImageUrl()).append("url", item.getUrl())
							.append("categories", item.getCategories()).append("distance", item.getDistance()));
		}
	}

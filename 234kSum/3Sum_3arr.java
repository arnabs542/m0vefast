public boolean exist(int[] a, int[] b, int[] c, int target) {
    // Write your solution here
  }

n^3
n
  bool findTriplet(int a1[], int a2[], int a3[],
                int n1, int n2, int n3, int sum)
  {
      // Store elements of first array in hash
      unordered_set <int> s;
      for (int i=0; i<n1; i++)
          s.insert(a1[i]);

      // sum last two arrays element one by one
      for (int i=0; i<n2; i++)
      {
          for (int j=0; j<n3; j++)
          {
              // Consider current pair and find if there
              // is an element in a1[] such that these
              // three form a required triplet
              if (s.find(sun - a2[i] - a3[j]) != s.end())
                   return true;
          }
      }

      return false;
  }

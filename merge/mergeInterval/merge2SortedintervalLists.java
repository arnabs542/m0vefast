public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
       List<Interval> results = new ArrayList<>();
       if (list1 == null || list2 == null) {
           return results;
       }
       //toAdd 来记录最后一个还没有被放到 merge results 里的 Interval，用于和新加入的 interval 比较看看能不能合并到一起。
       Interval toAdd = null;
       Interval curt = null;
       int i = 0;
       int j = 0;
       while (i < list1.size() && j < list2.size()) {
           if (list1.get(i).start < list2.get(j).start) {
               curt = list1.get(i);
               i++;
           } else {
               curt = list2.get(j);
               j++;
           }
           toAdd = merge(results, toAdd, curt);
       }

       while (i < list1.size()) {
           toAdd = merge(results, toAdd, list1.get(i));
           i++;
       }

       while (j < list2.size()) {
           toAdd = merge(results, toAdd, list2.get(j));
           j++;
       }
       //list1 and 2 has same length
       if (toAdd != null) {
           results.add(toAdd);
       }
       return results;
   }

   private Interval merge(List<Interval> results, Interval toAdd, Interval curt) {
       if (toAdd == null) {
           return curt;
       }

       if (toAdd.end < curt.start) {
           results.add(toAdd);
           return curt;
       }
       //curt.start <= toAdd.end: need to merge
       toAdd.end = Math.max(toAdd.end, curt.end);
       return toAdd;
   }

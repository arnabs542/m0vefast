public int numUniqueEmails(String[] emails) {
        if(emails == null || emails.length == 0)
            return 0;
        Set<String> set = new HashSet<>();
        for(String each : emails){
            String[] parts = each.split("@");
            //https://stackoverflow.com/questions/32112980/how-to-escape-character-in-java
            //+ one or more times, \ tab
            Stirng[] local = parts[0].split("\\+");
            set.add(local[0].replace(".","") + "@" +  parts[1]);
        }
        return set.size();
    }

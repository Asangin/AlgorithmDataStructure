package com.skryl.structure;

public class HashTable {
	static class HashEntry {
        public String value;
        public HashEntry(String value) {
            this.value = value;
        }
    }
    static class HashMap {
        int TABLE_SIZE = 127;
        public HashEntry[] table;
        
        public HashMap() {
        table = new HashEntry[127];
            for (int k = 0; k < TABLE_SIZE; k++) {
                table[k] = null;
            }
        }
        
        int HashFunc(String value) {
            int key = 0;
            char[] charArray = value.toCharArray();
            for(int i = 0; i < value.length(); i++) {
                key += charArray[i];
            }
            return key % TABLE_SIZE;
        }
        void insert(String value) {
            int hash = HashFunc(value);
            if(table[hash] == null)
                table[hash] = new HashEntry(value);
        }
        HashEntry search(String value) {
            int hash = HashFunc(value);
            if (table[hash] == null) {
                System.out.println("Value {" + value + "} not found.");
                return null;
            } else {
                return table[hash];
            }
        }
        void remove(String value) {
            int hash = HashFunc(value);
            if (table[hash] != null) {
                table[hash] = null;
            }
        }
    }
    public static void main(String[] args) {
        HashMap hash = new HashMap();
        hash.insert("Adolf");
        hash.insert("Barbon");
        hash.insert("Carbon");
        System.out.println(hash.search("Adolf"));
        hash.remove("Barbon");
        System.out.println(hash.search("Barbon"));
    }
}

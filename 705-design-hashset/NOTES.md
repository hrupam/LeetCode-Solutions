It was my manual approach, not executing
​
```
private List<Integer> list;
public MyHashSet() {
list=new ArrayList<>();
}
public void add(int key) {
if(contains(key)) return;
int index=-1;
int l=0;
int h=list.size()-1;
while(l<=h){
int mid=(l+h)/2;
if(list.get(mid)==key){
index=mid;
break;
}
else if(key>list.get(mid)) l=mid+1;
else h=mid-1;
}
if(index==-1) index=Math.max(l,h);
list.add(index,key);
}
public void remove(int key) {
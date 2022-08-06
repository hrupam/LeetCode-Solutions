# Recursive
​
```
private static boolean f(int l, int r, char[] str) {
if (l >= r) return true;
if (!Character.isLetterOrDigit(str[l])) return f(l + 1, r, str);
if (!Character.isLetterOrDigit(str[r])) return f(l, r - 1, str);
if (Character.toLowerCase(str[l]) != Character.toLowerCase(str[r])) return false;
​
return f(l + 1, r - 1, str);
}
```
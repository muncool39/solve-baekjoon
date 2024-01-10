## 유클리드 호제법
```java
int gcd(int p, int q){
	if (q == 0) return p;
	return gcd(q, p%q);
}
```
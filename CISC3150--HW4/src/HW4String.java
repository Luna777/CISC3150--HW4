//CISC3150 
//XIN GUAN
//09/28/2015

public class HW4String{
	
	public static void main(String[] args){
		
		char[] c= {'H', 'e', 'l', 'l', 'o', 'K', 'i', 't', 't', 'y'};
		System.out.println("the char array that will put into MyString is: ");
		System.out.println(c);
		System.out.println();
		
		//MyString class
		MyString s1= new MyString(c);
		
		System.out.println("get char at position 5: \n"+ s1.charAt(5));
		System.out.println();
		System.out.println("get MyString's length: \n"+ s1.length());
		System.out.println();
		System.out.println("get the substring from position 5 to 9: \n"+ s1.substring(5,9).toString());
		System.out.println();
		System.out.println("to lowercase: \n"+ s1.toLowerCase().toString());
		System.out.println();
		System.out.println("to uppercase: \n"+ s1.toUpperCase().toString());
		System.out.println();
		char[] d={'K', 'i', 't', 't', 'y', 'K', 'i', 't', 't', 'y'};
		char[] e={'H', 'e', 'l', 'l', 'o', 'K', 'i', 't', 't', 'y'};
		System.out.println("is it equal to KittyKitty? \n"+ s1.equals(new MyString(d)));
		System.out.println();
		System.out.println("is it equal to HelloKitty? \n"+ s1.equals(new MyString(e)));
		System.out.println();
		System.out.println("getMyString(): \n"+ s1.getMyString().toString());
		System.out.println();
		System.out.println("print out MyString: \n"+ s1.toString());
		System.out.println();
		System.out.println("valueOf(1235555): \n"+ MyString.valueOf(1235555).toString());
		System.out.println();
		
	}
	
}

class MyString{
	private char[] myChars;
	
	public MyString(char[] chars){
		myChars=new char[chars.length];
		for(int i=0; i<chars.length; i++){
			myChars[i]=chars[i];
		}
		
	}
	public char charAt(int index){
		char c= myChars[index];
		return c;
		
	}
	public int length(){
		int l=myChars.length;
		return l;
		
	}
	public MyString substring(int begin, int end){
		int l=end-begin+1;
		char[] newChars= new char[l];
		for(int i=0; i<l; i++){
			newChars[i]=myChars[begin+i];
		}
		MyString ms= new MyString(newChars);
		return ms;
		
	}
	public MyString toLowerCase(){
		char[] newChars= new char[myChars.length];
		for(int i=0; i<myChars.length; i++){
			if(myChars[i]>=65 && myChars[i]<=90){
				newChars[i]=(char)(myChars[i] + 32);
			}
			else{
				newChars[i]=myChars[i];
			}
		}
		MyString ms= new MyString(newChars);
		return ms;
		
	}
	public MyString toUpperCase(){
		char[] newChars= new char[myChars.length];
		for(int i=0; i<myChars.length; i++){
			if(myChars[i]>=97 && myChars[i]<=122){
				newChars[i]=(char)(myChars[i] - 32);
			}
			else{
				newChars[i]=myChars[i];
			}
		}
		MyString ms= new MyString(newChars);
		return ms;
		
	}
	public boolean equals(MyString s){
		if(s.length()==myChars.length){
			for(int i=0; i<myChars.length; i++){
				if(s.charAt(i)!=myChars[i]){
					return false;
				}
			}
			return true;
		}
		else{
			return false;
		}
		
	}
	public MyString getMyString(){
		char[] newChars= new char[myChars.length];
		for(int i=0; i<newChars.length;i++){
			newChars[i]=myChars[i];
		}
		MyString ms= new MyString(newChars);
		return ms;
	}
	public String toString(){
		String s= new String(myChars);
		return s;
		
	}
	public static MyString valueOf(int i){
		int remainder=-1;
		int counter=0; //get how many digits of i.
		int t=10;
		//divide i by 10, 100, 1000.... until the remainder=i;
		//how many times loop runs, how many digits that i has.
		while(remainder!=i){ 
			remainder=i%t;	
			t=t*10;
			counter++;
		}
		//now we know how many chars should be initialized.
		char[] c= new char[counter];
		remainder=0;//reset remainder
		//put each digit of i into char[] c
		for(int j=0; j<c.length; j++){ 
			remainder=i%10;
			i=(i-remainder)/10;
			c[c.length-j-1]=(char)(remainder+48);
		}
		
		MyString ms= new MyString(c);
		return ms;
		
	}
	
}


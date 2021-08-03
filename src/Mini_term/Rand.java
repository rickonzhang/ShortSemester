package Mini_term;

import java.util.Random;

public class Rand {
	public static String password(){
		int  maxNum = 62;

		int i;  //生成的随机数

		int count = 0; //生成的密码的长度

		char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
		'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
		'x', 'y', 'z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V',
		'W','X','Y','Z','0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		StringBuffer pwd = new StringBuffer("");

		Random r = new Random();

		while(count < 10){
		//生成随机数，取绝对值，防止生成负数，

		i = Math.abs(r.nextInt(maxNum));  //生成的数最大为36-1

		if (i >= 0 && i < str.length) {
		pwd.append(str[i]);

		count ++;

		}

		}

		return pwd.toString();
		
	}

}

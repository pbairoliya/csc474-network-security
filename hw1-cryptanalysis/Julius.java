import java.util.Base64;

public class Julius {

   public static String encode (byte[] text)
   {
	  return Base64.getEncoder().encodeToString(text);
   }

   public static byte[] decode (String text)
   {
	  return Base64.getDecoder().decode(text);
   }

   public static byte[] encrypt(byte[] cleartext, byte key)
   {
	  byte[] toReturn = new byte[cleartext.length];
	  for (int i = 0; i < cleartext.length; i++)
	  {
		 toReturn[i] = (byte) (cleartext[i] ^ key);
	  }
	  return toReturn;
   }

   public static void main(String[] args)
   {    
        //brue force algorithm
        for (int i =0; i< 255; i++){
            System.out.println(new String((encrypt(decode("7fq/6Prt+r/57fru6vrx67/s9Pbt8vbs9/rsv/787fDs7L/r9/q/8v7t7Pezv/6/+frov/Dxv/3w6/e/7Pb7+uy/7P7z8+b28fi/8Orrv/366+j6+vG/6/f6v+vo8L/8/vLv7LG/zPDy+uv28vrss7/38Oj66frts7/w6u2/2P7z8/b8v/Dtv9j67fL+8b/+6uf28/b+7fb67L/87fDs7Pr7v+v3+r/y/u3s97O//vH7v/nq7fbw6uzz5r/v6u3s6vr7v+v3+r/68fry5qS/8O2/8PG/6/f6v/Dr9/rtv/f+8fu/6/f6v/rx+vLmv+/+7Oz6+7/267/+8fu//fr+67/9/vz0v/Dq7b/y+vGxv9Lw7frw6frtv+v3+u36v/f+7+/68fr7v/bxv+v3+r/88Ort7Pq/8Pm/8Ortv/v+9vPmv/nw7f749vH4s7/o9/7rv/Lq7Ou/8Pm/8fr8+uzs9uvmv/f+7+/68bO/6Pf68b/88O3xv/bsv+vwv/36v/zw8/P6/Ov6+7/95r/+v/n66L/s/P7r6/rt+vu/8vrxv/Dq67/w+b/v7fbp/uv6v/fw6uz67LO/6/f+67/w6u2/+fDt/vj67ey/+/bs7/rt7Pbx+L/28b/+8b/28evt9vz+6/q//PDq8evt5r/o+u36v+zq7e3w6vH7+vu//ea/6/f6v/rx+vLmpL/95r/o9/b897O/6/fw6vj3v+j6v+zq+fn67fr7v/3q67/+8b/28fzw8ez2+/rt/v3z+r/z8Ozsv/"
            + "D5v/z+6+vz+r/+8fu/7Prt6f7x6+yzv+b667/267/t/vbs+vu/+fDw8/bs97/38O/67L/28b/r9/q//f7t/f7"
            + "t9v7x7KS//errv/Lw7fq/+uzv+vz2/vPz5rO//fr8/urs+r/c8PL26uyzv+j38L/Wv+z+9vu/9/77v/jw8fq/6/C/+P"
            + "rrv/72+7/57fDyv+v3+r/Y+u3y/vHss7/t+uvq7fH6+7/o9uv3v+zw8vq//P7p/vPt5rO//vH7v+v38Or"
            + "497/r9/q/2Prt8v7x7L/o+u36v/Dx8+a/qq+vs7/m+uu/6/f6v/3+7f3+7fb+8ey/6Prt+r/68/7r+vu//ea/6/f69u"
            + "2//u3t9un+87GVlcfWsbLc/vrs/u2zv/D97Prt6fbx+L/r9/7rv+v3+r/68fry5r/0+u/rv/nw7b/s+un67f7zv/v+5u"
            + "y/6Pbr9/bxv+v3+vbtv/z+8u+zv+j39vz3v+j+7L/o+vPzv+z6/Ort+vu//ea//r/y8O3+7Oy//vH7v/br7L/x/uvq7f7zv+z26+"
            + "r+6/bw8bO//vH7v+v3/uu/9uu//PDq8/u/8fDrv/36v/7s7P7q8+v6+7/o9uv38Orrv/6/+/7x+Prt8Orsv/rx+P74+vL68euzv/Hw7b/r9/q/7/"
            + "P+/Pq/+vH88/Ds+vu/6Pbr97/z9vH67L/o9uv38Orrv/7xv/77+/br9vDxv+vwv/f27L/+7fLms7/o7fDr+r/r8L/L7fr98PH26uy/6/C/7Prx+7/o9uv"
            + "3v/7z87/7+uzv/uv897/58O2/6/f6v+v39u3r+vrx6/e/8/r49vDxv+j39vz3v+j+7L/28b/o9vHr+u2y7ur+7ev67ey//vLw8fi/6/f6v9326+rt9vj67L"
            + "/q8fv67b/L9uvq7L/M+ufr9urss7/w8fq/8Pm/9/bsv/P2+urr+vH+8evspL/+8fu/6/f68b/r8L/88PL6v+vwv/f28r/95r/58O38+vu/8v7t/Pf67L/o9uv3v"
            + "+v3+r/r9+36+r/z+vj28PHssb/X+r/39vLs+vP5v+z68eu/6/f6v/z+6f7z7ea/8Pm/6/f6v8368vazv/7x+7/T9vH48PH67LO//vH7v/Dr9/rtv+zr/uv67LO/+e3w"
            + "8r/o9/Dyv/f6v/f++7/t+u7q9u36+7/+v+n+7Ou/8ery/frts7/r8L/46v7t+7/39uy/+fDt/vj28fi/7/7t6/b67LO//vH7v+vwv+zq7+/w7eu/6/f68r/28b/8/uz6v/D5v/7x5r/s6vv7+vG//uvr/vz0v/D5v+v3+r/68fry5rGVlcfW1rF9Hwve7L/r9/bsv/zw8ev28er6+7/58O2/7Prp+u3+87/7/ubss7/+8fu/6/f69u2/6fb49vP+8fz6v+j+7L/t+vP+5/"
            + "r7v/3mv/zq7Ovw8r+3/vG/+vn5+vzrv+j39vz3v/bsv/j68frt/vPz5r/v7fD76vz6+7/95r/r9vL6trO/6/f6v9368/Pw6f789rO/9/7p9vH4v/L++/q/6/f68"
            + "uz68+n67L/+/O7q/vbx6/r7v+j26/e/6/f6v/v+9vPmv+zr/uv28PHsv/D5v/Dq7b/38O3s+rO/8/b6v/bxv/7y/ers97/o9uv3v/6/7Prz+vzrv/3w++a/8Pm/"
            + "+fDw67/28b/+v+/z/vz6v/zw6frt+vu/6Pbr97/o8PD77KS/6/C/9uu/6/f65r/s+vHrv+v3+vbtv/fw7ez6v+v3+r/x+ufrv/v+5rO/6Pfwv+j67fq/+fbt7Ou/6/C/+/r88Oa/8Ortv/L68b/28evwv+v3+r/+8v3q7Pz++/qzv/7x+7/r9/rxv+j3+vG/6/f65r/o+u36v+zq7e3w6vH7+vuzv+vwv/7r6/789L/r"
            + "9/rysQ=="), (byte)159))));
        }

            // double checking if the key is accurate
       	  System.out.println(new String((encrypt(decode("7fq/6Prt+r/57fru6vrx67/s9Pbt8vbs9/rsv/787fDs7L/r9/q/8v7t7Pezv/6/+frov/Dxv/3w6/e/7Pb7+uy/7P7z8+b28fi/8Orrv/366+j6+vG/6/f6v+vo8L/8/vLv7LG/zPDy+uv28vrss7/38Oj66frts7/w6u2/2P7z8/b8v/Dtv9j67fL+8b/+6uf28/b+7fb67L/87fDs7Pr7v+v3+r/y/u3s97O//vH7v/nq7fbw6uzz5r/v6u3s6vr7v+v3+r/68fry5qS/8O2/8PG/6/f6v/Dr9/rtv/f+8fu/6/f6v/rx+vLmv+/+7Oz6+7/267/+8fu//fr+67/9/vz0v/Dq7b/y+vGxv9Lw7frw6frtv+v3+u36v/f+7+/68fr7v/bxv+v3+r/88Ort7Pq/8Pm/8Ortv/v+9vPmv/nw7f749vH4s7/o9/7rv/Lq7Ou/8Pm/8fr8+uzs9uvmv/f+7+/68bO/6Pf68b/88O3xv/bsv+vwv/36v/zw8/P6/Ov6+7/95r/+v/n66L/s/P7r6/rt+vu/8vrxv/Dq67/w+b/v7fbp/uv6v/fw6uz67LO/6/f+67/w6u2/+fDt/vj67ey/+/bs7/rt7Pbx+L/28b/+8b/28evt9vz+6/q//PDq8evt5r/o+u36v+zq7e3w6vH7+vu//ea/6/f6v/rx+vLmpL/95r/o9/b897O/6/fw6vj3v+j6v+zq+fn67fr7v/3q67/+8b/28fzw8ez2+/rt/v3z+r/z8Ozsv/"
       	  		+ "D5v/z+6+vz+r/+8fu/7Prt6f7x6+yzv+b667/267/t/vbs+vu/+fDw8/bs97/38O/67L/28b/r9/q//f7t/f7"
       	  		+ "t9v7x7KS//errv/Lw7fq/+uzv+vz2/vPz5rO//fr8/urs+r/c8PL26uyzv+j38L/Wv+z+9vu/9/77v/jw8fq/6/C/+P"
       	  		+ "rrv/72+7/57fDyv+v3+r/Y+u3y/vHss7/t+uvq7fH6+7/o9uv3v+zw8vq//P7p/vPt5rO//vH7v+v38Or"
       	  		+ "497/r9/q/2Prt8v7x7L/o+u36v/Dx8+a/qq+vs7/m+uu/6/f6v/3+7f3+7fb+8ey/6Prt+r/68/7r+vu//ea/6/f69u"
       	  		+ "2//u3t9un+87GVlcfWsbLc/vrs/u2zv/D97Prt6fbx+L/r9/7rv+v3+r/68fry5r/0+u/rv/nw7b/s+un67f7zv/v+5u"
       	  		+ "y/6Pbr9/bxv+v3+vbtv/z+8u+zv+j39vz3v+j+7L/o+vPzv+z6/Ort+vu//ea//r/y8O3+7Oy//vH7v/br7L/x/uvq7f7zv+z26+"
       	  		+ "r+6/bw8bO//vH7v+v3/uu/9uu//PDq8/u/8fDrv/36v/7s7P7q8+v6+7/o9uv38Orrv/6/+/7x+Prt8Orsv/rx+P74+vL68euzv/Hw7b/r9/q/7/"
       	  		+ "P+/Pq/+vH88/Ds+vu/6Pbr97/z9vH67L/o9uv38Orrv/7xv/77+/br9vDxv+vwv/f27L/+7fLms7/o7fDr+r/r8L/L7fr98PH26uy/6/C/7Prx+7/o9uv"
       	  		+ "3v/7z87/7+uzv/uv897/58O2/6/f6v+v39u3r+vrx6/e/8/r49vDxv+j39vz3v+j+7L/28b/o9vHr+u2y7ur+7ev67ey//vLw8fi/6/f6v9326+rt9vj67L"
       	  		+ "/q8fv67b/L9uvq7L/M+ufr9urss7/w8fq/8Pm/9/bsv/P2+urr+vH+8evspL/+8fu/6/f68b/r8L/88PL6v+vwv/f28r/95r/58O38+vu/8v7t/Pf67L/o9uv3v"
       	  		+ "+v3+r/r9+36+r/z+vj28PHssb/X+r/39vLs+vP5v+z68eu/6/f6v/z+6f7z7ea/8Pm/6/f6v8368vazv/7x+7/T9vH48PH67LO//vH7v/Dr9/rtv+zr/uv67LO/+e3w"
       	  		+ "8r/o9/Dyv/f6v/f++7/t+u7q9u36+7/+v+n+7Ou/8ery/frts7/r8L/46v7t+7/39uy/+fDt/vj28fi/7/7t6/b67LO//vH7v+vwv+zq7+/w7eu/6/f68r/28b/8/uz6v/D5v/7x5r/s6vv7+vG//uvr/vz0v/D5v+v3+r/68fry5rGVlcfW1rF9Hwve7L/r9/bsv/zw8ev28er6+7/58O2/7Prp+u3+87/7/ubss7/+8fu/6/f69u2/6fb49vP+8fz6v+j+7L/t+vP+5/"
       	  		+ "r7v/3mv/zq7Ovw8r+3/vG/+vn5+vzrv+j39vz3v/bsv/j68frt/vPz5r/v7fD76vz6+7/95r/r9vL6trO/6/f6v9368/Pw6f789rO/9/7p9vH4v/L++/q/6/f68"
       	  		+ "uz68+n67L/+/O7q/vbx6/r7v+j26/e/6/f6v/v+9vPmv+zr/uv28PHsv/D5v/Dq7b/38O3s+rO/8/b6v/bxv/7y/ers97/o9uv3v/6/7Prz+vzrv/3w++a/8Pm/"
       	  		+ "+fDw67/28b/+v+/z/vz6v/zw6frt+vu/6Pbr97/o8PD77KS/6/C/9uu/6/f65r/s+vHrv+v3+vbtv/fw7ez6v+v3+r/x+ufrv/v+5rO/6Pfwv+j67fq/+fbt7Ou/6/C/+/r88Oa/8Ortv/L68b/28evwv+v3+r/+8v3q7Pz++/qzv/7x+7/r9/rxv+j3+vG/6/f65r/o+u36v+zq7e3w6vH7+vuzv+vwv/7r6/789L/r"
       	  		+ "9/rysQ=="), (byte)159))));

 

   }
}

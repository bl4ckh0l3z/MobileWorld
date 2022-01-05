/*
  Decryptor for Donot samples strings;
  tested on e1c24030653d15ee673627bf28f165d1a30be5027b8cd4186ac6bfd9809e8cb8.
  by bl4ckh0l3z
*/

import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.security.*;

public class Decryptor {

	public static void main(String[] args) {
        String data_cypher = args[0];
	    String data_plain = C1361a.m4080a(args[0]);
	    System.out.println(data_plain);
	}
}

class C1361a {
    public static final IvParameterSpec f4998d = new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    public final Key f4999a;
    public final IvParameterSpec f5000b;
    public Cipher f5001c;

    public C1361a(String str, int i, String str2) {
        this.f4999a = i == 256 ? new SecretKeySpec(m4081c("SHA-256", str), "AES") : new SecretKeySpec(m4081c("MD5", str), "AES");
        this.f5000b = str2 != null ? new IvParameterSpec(m4081c("MD5", str2)) : f4998d;
        try {
            this.f5001c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String m4080a(String str) {
        try {
            return new C1361a(C1357a.m4077a("9Tk8fR5fK/rSAJUYdsof5Q=="), 128, C1357a.m4077a("9Tk8fR5fK/rSAJUYdsof5Q==")).mo5383b(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] m4081c(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                instance.update(bytes);
                return instance.digest();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2.getMessage());
        }
    }

    public String mo5383b(String str) {
        try {
            byte[] decode = Base64.getDecoder().decode(str);
            try {
                this.f5001c.init(2, this.f4999a, this.f5000b);
                return new String(this.f5001c.doFinal(decode), StandardCharsets.UTF_8);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2.getMessage());
        }
    }
}

class C1357a {
    public static final IvParameterSpec f4992d = new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    public final Key f4993a;
    public final IvParameterSpec f4994b;
    public Cipher f4995c;

    public C1357a(String str, int i, String str2) {
        this.f4993a = i == 256 ? new SecretKeySpec(m4078c("SHA-256", str), "AES") : new SecretKeySpec(m4078c("MD5", str), "AES");
        this.f4994b = new IvParameterSpec(m4078c("MD5", str2));
        try {
            this.f4995c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String m4077a(String str) {
        try {
            return new C1357a("n@peC0de1st", 128, "n@peC0de1st").mo5372b(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] m4078c(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                instance.update(bytes);
                return instance.digest();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2.getMessage());
        }
    }

    public String mo5372b(String str) {
        try {
            byte[] decode = Base64.getDecoder().decode(str);
            try {
                this.f4995c.init(2, this.f4993a, this.f4994b);
                return new String(this.f4995c.doFinal(decode), StandardCharsets.UTF_8);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2.getMessage());
        }
    }
}

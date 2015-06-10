import java.io.UnsupportedEncodingException;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/**
 * File         DesEncrypter.java
 *
 * Created      09.08.2011, 11:35:33
 * Last Update  09.08.2011, 11:35:33
 * --------------------------------------------------
 * History:
 * $Log$
 *
 */

/**
 * TODO Class description <br>
 * <br>
 * Copyright:   Copyright (c) 2011 <br>
 * Company:     b-next Engineering GmbH <br>
 * Creator:     Stefan Sayk <br>
 *
 * @author      $Author:$, $Date:$
 * @version     $Revision:$
 */
public class DesEncrypter
{
    Cipher ecipher;
    Cipher dcipher;

    DesEncrypter( SecretKey key )
    {
        try
        {
            ecipher = Cipher.getInstance( "DES" );
            dcipher = Cipher.getInstance( "DES" );
            ecipher.init( Cipher.ENCRYPT_MODE, key );
            dcipher.init( Cipher.DECRYPT_MODE, key );

        }
        catch( javax.crypto.NoSuchPaddingException e )
        {
        }
        catch( java.security.NoSuchAlgorithmException e )
        {
        }
        catch( java.security.InvalidKeyException e )
        {
        }
    }

    public String encrypt( String str )
    {
        try
        {
            // Encode the string into bytes using utf-8
            byte[] utf8 = str.getBytes( "UTF8" );

            // Encrypt
            byte[] enc = ecipher.doFinal( utf8 );

            // Encode bytes to base64 to get a string
            return new sun.misc.BASE64Encoder().encode( enc );
        }
        catch( javax.crypto.BadPaddingException e )
        {
        }
        catch( IllegalBlockSizeException e )
        {
        }
        catch( UnsupportedEncodingException e )
        {
        }
        catch( java.io.IOException e )
        {
        }
        return null;
    }

    public String decrypt( String str )
    {
        try
        {
            // Decode base64 to get bytes
            byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer( str );

            // Decrypt
            byte[] utf8 = dcipher.doFinal( dec );

            // Decode using utf-8
            return new String( utf8, "UTF8" );
        }
        catch( javax.crypto.BadPaddingException e )
        {
        }
        catch( IllegalBlockSizeException e )
        {
        }
        catch( UnsupportedEncodingException e )
        {
        }
        catch( java.io.IOException e )
        {
        }
        return null;
    }

    public static void main( String[] args )
    {
        try
        {
            //            // Generate a temporary key. In practice, you would save this key.
            //            // See also Encrypting with DES Using a Pass Phrase.
            //
            //            SecretKey key = KeyGenerator.getInstance( "DES" ).generateKey();
            //
            //            // Create encrypter/decrypter class
            //            DesEncrypter encrypter = new DesEncrypter( key );
            //            DesEncrypter encrypter2 = new DesEncrypter( KeyGenerator.getInstance( "DES" ).generateKey() );
            //
            //            // Encrypt
            //            String encrypted = encrypter.encrypt( "Don't tell anybody!\n mit umlautenÄÖÜ\täöü" );
            //            System.out.println( encrypted );
            //            // Decrypt
            //            String decrypted = encrypter.decrypt( encrypted );
            //            System.out.println( decrypted );
            //
            //            decrypted = encrypter2.decrypt( encrypted );
            //            System.out.println( decrypted );

            KeyGenerator kg = KeyGenerator.getInstance( "DESede" );
            Key sharedKey = kg.generateKey();

            String password = "password";
            byte[] salt = "salt1234".getBytes();
            PBEParameterSpec paramSpec = new PBEParameterSpec( salt, 20 );
            PBEKeySpec keySpec = new PBEKeySpec( password.toCharArray() );
            SecretKeyFactory kf = SecretKeyFactory.getInstance( "PBEWithMD5AndDES" );
            SecretKey passwordKey = kf.generateSecret( keySpec );
            Cipher c = Cipher.getInstance( "PBEWithMD5AndDES" );
            c.init( Cipher.WRAP_MODE, passwordKey, paramSpec );
            byte[] wrappedKey = c.wrap( sharedKey );

            c = Cipher.getInstance( "DESede" );
            c.init( Cipher.ENCRYPT_MODE, sharedKey );
            byte[] input = "input".getBytes();
            byte[] encrypted = c.doFinal( input );

            c = Cipher.getInstance( "PBEWithMD5AndDES" );

            c.init( Cipher.UNWRAP_MODE, passwordKey, paramSpec );
            Key unwrappedKey = c.unwrap( wrappedKey, "DESede", Cipher.SECRET_KEY );

            c = Cipher.getInstance( "DESede" );
            c.init( Cipher.DECRYPT_MODE, unwrappedKey );
            System.out.println( new String( c.doFinal( encrypted ) ) );

        }
        catch( Exception e )
        {
        }

    }

}

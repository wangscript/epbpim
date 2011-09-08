/**
 * Copyright (c) coship 2007
 * @author: ives
 * @date: 2007-8-28 ����02:51:13
 * @version: 1.0
 */
package com.ryxx.util.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author ives
 * 
 */
public class FileUtil
{
    private static final int BUFFER_SIZE = 16 * 1024;
    
    /**
     * 文件复制/剪切
     * <功能详细描述>
     * 
     * @param src 源文件
     * @param dst 目标文件
     * @param delSrc 是否将源文件删除 false 相当于文件复制，true 相当于文件剪切
     * @author zhangxiaohui
     * @throws Exception 异常
     */
    public static void copy(File src, File dst, boolean delSrc)
        throws Exception
    {
        
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try
        {
            in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
            out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);
            byte[] buffer = new byte[BUFFER_SIZE];
            int c;
            while (0 < (c = in.read(buffer)))
            {
                out.write(buffer, 0, c);
            }
        }
        finally
        {
            try
            {
                out.close();
            }
            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    in.close();
                }
                catch (Exception e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            
        }
        if (delSrc)
        {
            delete(src);
        }
    }
    
    //	public static void copy(File src, File dst) {
    //		try {
    //			InputStream in = null;
    //			OutputStream out = null;
    //			try {
    //				in = new BufferedInputStream(new FileInputStream(src),
    //						BUFFER_SIZE);
    //				out = new BufferedOutputStream(new FileOutputStream(dst),
    //						BUFFER_SIZE);
    //				byte[] buffer = new byte[BUFFER_SIZE];
    //				while (in.read(buffer) > 0) {
    //					out.write(buffer);
    //				}
    //			} finally {
    //				if (null != in) {
    //					in.close();
    //				}
    //				if (null != out) {
    //					out.close();
    //				}
    //			}
    //		} catch (Exception e) {
    //			e.printStackTrace();
    //		}
    //	}
    
    public static void delete(File file)
    {
        try
        {
            if (file.exists())
            {
                System.out.println(file.getAbsolutePath());
                file.delete();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void delete(String filename)
    {
        File file = new File(filename);
        delete(file);
    }
}
package com.ibeetl.code.ch05.messagePack;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.msgpack.MessagePack;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.jackson.dataformat.MessagePackFactory;

import java.io.IOException;
import java.util.Date;

/**
 * msg pack 测试
 * @author 公众号 闲谈java开发
 */
public class PackSizeTest {
	public static void main(String[] args) throws IOException {
		Product product = getProudct();

		MessagePack pack = new MessagePack();
		ObjectMapper mapper = new ObjectMapper();

		ObjectMapper messagePackMapper = new ObjectMapper(new MessagePackFactory());

		byte[] bs = pack.write(product);
		byte[] bs1 = packProudct(product);
		byte[] bs3 =  messagePackMapper.writeValueAsBytes(product);
		String str = mapper.writeValueAsString(product);
		System.out.println("autopack size = " +bs.length);
		System.out.println("pack size = " +bs1.length);
		System.out.println("jackson pack size = " +bs1.length);
		System.out.println("jackson size = " +str.getBytes("UTF-8").length);

	}

	static Product getProudct(){
		Product p = new Product();
		p.setDel(true);
		p.setCreateTime(new Date());
		p.setDescription("product");
		p.setId(1);
		p.setName("雨伞");
		p.setPrice(32.1);
		p.setProductStatus(true);
		p.setUpdateTime(null);
		return p;
	}


	static private byte[] packProudct(Product p) throws IOException{
		MessageBufferPacker packer = org.msgpack.core.MessagePack.newDefaultBufferPacker();
		packer.packBoolean(p.getDel());
		packer.packLong(p.getCreateTime().getTime());
		packer.packString(p.getDescription());
		packer.packInt(p.getId());
		packer.packString(p.getName());
		packer.packBoolean(p.getProductStatus());
		packer.packNil();
		return packer.toByteArray();
	}
}

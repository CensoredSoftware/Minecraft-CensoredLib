package com.censoredsoftware.censoredlib.data;

import com.google.common.base.Objects;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ServerData implements ConfigurationSerializable
{
	private UUID id;
	private String key;
	private String subKey;
	private String data;
	private String type;

	public ServerData()
	{}

	public ServerData(UUID id, ConfigurationSection conf)
	{
		this.id = id;
		key = conf.getString("key");
		subKey = conf.getString("subKey");
		data = conf.getString("data");
		type = conf.getString("type");
	}

	@Override
	public Map<String, Object> serialize()
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key", key);
		map.put("subKey", subKey);
		map.put("data", data);
		map.put("type", type);
		return map;
	}

	public void generateId()
	{
		id = UUID.randomUUID();
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public void setSubKey(String subKey)
	{
		this.subKey = subKey;
	}

	public void setData(Object data)
	{
		this.data = data.toString();
		this.type = data.getClass().getName();
	}

	public UUID getId()
	{
		return this.id;
	}

	public String getKey()
	{
		return this.key;
	}

	public String getSubKey()
	{
		return this.subKey;
	}

	public Object getData()
	{
		if(this.type.equalsIgnoreCase("string")) return this.data;
		if(this.type.equalsIgnoreCase("integer")) return Integer.parseInt(this.data);
		if(this.type.equalsIgnoreCase("boolean")) return java.lang.Boolean.parseBoolean(this.data);
		return this.data;
	}

	@Override
	public boolean equals(final Object obj)
	{
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		final ServerData other = (ServerData) obj;
		return Objects.equal(this.id, other.id) && Objects.equal(this.key, other.key) && Objects.equal(this.subKey, other.subKey) && Objects.equal(this.data, other.data);
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(this.id, this.key, this.subKey, this.data);
	}

	@Override
	public String toString()
	{
		return Objects.toStringHelper(this).add("id", this.id).add("key", this.key).add("subkey", this.subKey).add("data", this.data).toString();
	}

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		throw new CloneNotSupportedException();
	}
}
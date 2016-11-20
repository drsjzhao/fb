package cn.wasu.cloudhospital.toufu.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

public final class Config extends HashMap<String, String> {

  private static final long serialVersionUID = -3409090390697194796L;
  private final static ObjectMapper mapper = new ObjectMapper();
  private static Config INSTANCE = null;

  public static Config getInstance() {
    if (INSTANCE == null) {
      synchronized (Config.class) {
        if (INSTANCE == null) {
          INSTANCE = new Config();
        }
      }
    }
    return INSTANCE;
  }

  private Config() {
    try {
      BufferedReader fileReader = new BufferedReader(new InputStreamReader(
          JsonParser.class.getResourceAsStream("/toufu_config.txt")));

      JsonNode rootNode = mapper.readTree(fileReader);
      this.put("fbook.server", rootNode.path("fbook.server").getTextValue().trim());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

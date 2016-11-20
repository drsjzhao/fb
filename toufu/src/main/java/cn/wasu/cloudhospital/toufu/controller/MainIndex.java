package cn.wasu.cloudhospital.toufu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.wasu.cloudhospital.toufu.module.PersonModule;
import cn.wasu.cloudhospital.toufu.module.WeightModule;
import cn.wasu.cloudhospital.toufu.util.SessionParser;

@Controller
public class MainIndex {

  @Value("#{properties['toufu.web.host']}")
  public String mainUrl;

  @Autowired
  private PersonModule personModule;
  @Autowired
  private WeightModule weightModule;

  private SessionParser sessionParser = new SessionParser();

  @RequestMapping(value = "/")
  public ModelAndView root(HttpServletRequest request) {
    ModelAndView view = new ModelAndView();
    view.setViewName("index");
    view.addObject("mainUrl", mainUrl);

    // 随机获取两个person
    List<Map<String, Object>> personList = personModule.getPairOfPersonRandom();
    view.addObject("personList", personList);

    sessionParser.setSession(request, "first_person", personList.get(0).get("index").toString());
    sessionParser.setSession(request, "second_person", personList.get(1).get("index").toString());

    return view;
  }

  @RequestMapping(value = "/winner")
  public ModelAndView winner(HttpServletRequest request, int winner_index) {
    Map<String, Object> q = new HashMap<>();
    q.put("person_index_1", sessionParser.getSession(request.getSession(), "first_person"));
    q.put("person_index_2", sessionParser.getSession(request.getSession(), "second_person"));
    q.put("winner_index", winner_index + 1);

    weightModule.compete(q);

    ModelAndView view = new ModelAndView();
    view.setViewName("redirect:" + "/");
    return view;
  }

}

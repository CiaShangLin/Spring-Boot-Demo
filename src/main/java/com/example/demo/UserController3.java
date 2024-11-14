package com.example.demo;

//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//    //注入JDBC模板接口
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//
//    /**
//     * 查询所有用户信息
//     */
//    @GetMapping("/get-users")
//    public List<Map<String, Object>> getUserList(){
//        //查询sql语句
//        String sql = "select * from user";
//        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
//        //返回结果
//        return list;
//    }
//}
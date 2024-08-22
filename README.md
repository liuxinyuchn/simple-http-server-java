# simple-http-server-java

- 仅一个 HTTP Connector，不支持 HTTPS
- 仅支持挂载到`/`的一个 Context，不支持多 Host 和多 Context
- 实现标准 Servlet 6 规范大部分功能
    - 支持 Servlet 组件
    - 支持 Filter 组件
    - 支持 Listener 组件
    - 支持 Session（仅限 Cookie 模式）
    - 不支持 JSP
    - 不支持 async 模式与 WebSocket
- 可部署一个标准的 Web APP
- 不支持同时部署多个 Web APP
- 不支持热部署
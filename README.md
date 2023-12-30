# church-service

## Introduction
This is an application that is designed to help the church manage congregation membership as new members come and go between congregations due to immigration. The application will allow a user to register as a member of the church at large and a member of the congregation in particular. 

Each congregation should belong to a parish and each Parish will belong to a circuit / denary and denary to a diocese. 

#### ADMINISTRATORS
The application is also designed to assist the administrators of the church to handle such admin work as :
* send bulk messages to congregants randomly
* post on a notice board for announcements and events planned ( Year planner so congregants can easily see these through their profile )
* Disable and enable members as they move to new places or decide to leave the church altogether
* Post content sermons, lectures, church literature, video sermons and other media that could profit the growth of the church.
* advertise merchandise that is being sold as a means of fund raising by the church.
* Act as platform for bible study discussions through text and maybe in the future tie it in with some conferencing software to enable video chat discussions.

#### CONGREGANTS / USERS

* register on the application
* update user profile
* add details of baptism history 
* family tree information and child birth and deaths
* marriage details
* able to comment on blog posts that are added by the ADMIN 
* reach the clergy through a private chat only accessible to the members of the church that have successfully registered
* add pledges for tithe and contributions and monitor their progress as the year progresses
* view church financial details and budgets 
* view church development plans in terms of details posted on the noticeboard

## How to run the application

----
Please run the following command from the working directory
```dockerfile
docker-compose -f docker/docker-compose.yaml up -d
```
### Services

----
* church-registration 
* gateway
* authority
* church-blog 

### Monitoring for the rest service

----
This application uses actuator to expose endpoints that allow for other services that can scrap the data to be able to scrap the data like [prometheus](https://prometheus.io/). There are configuration files that are in the docker folder to assist in starting a local Prometheus and Grafana docker image to test against this.
```dockerfile
docker-compose -f docker/prometheus-grafana.yaml up -d
```
Prometheus configuration is 
```yaml
scrape_configs:
  - job_name: 'ChurchRegistrationMetrics'
    metrics_path: '/church-registration/actuator/prometheus'
    scrape_interval: 5s
    static_configs:
      - targets: ['host.docker.internal:8090']
        labels:
          application: 'Church Registration'

  - job_name: 'ChurchBlogMetrics'
    metrics_path: '/church-blog/actuator/prometheus'
    scrape_interval: 5s
    static_configs:
      - targets: [ 'host.docker.internal:8091' ]
        labels:
          application: 'Church Blog'
```

Grafana configuration is 
```yaml
apiVersion: 1
datasources:
  - name: Prometheus
    type: prometheus
    access: proxy
    url: http://prometheus:9090
    isDefault: true
```
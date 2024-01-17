class Github {
    constructor() {
       this.api_url = 'https://api.github.com/users/';
       this.repos_count = 5;
       this.repos_sort = 'created: asc';
    }
 
    async getUser(user) {
       const profileResponse = 
       await fetch(
        `${this.api_url}${user}`);

       const repoResponse = 
       await fetch(
          `${this.api_url}${user}/repos
          ?per_page=${this.repos_count}&sort=${this.repos_sort}`
       );
 
       const profile = await profileResponse.json();
       const repos = await repoResponse.json();
 
       return {
        profile,
        repos
       }
    }
 }
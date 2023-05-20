import { Component, OnInit} from '@angular/core';
import { SearchService } from './search.service'

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit{
  searchTerm: string = '';
  totalData: any[] = [];
  filteredData: any[] = [];


  constructor(private searchService: SearchService) { }
ngOnInit(): void {
    this.getData();      
}

  getData() {
    this.searchService.search(this.searchTerm)
    .subscribe(data => {
      this.totalData = data;
      this.filter();  
    })    
  }

  search(){
this.filter();
  }

  filter() {    
    if(this.searchTerm === ""){
      this.filteredData = this.totalData
    } else{
    this.filteredData = this.totalData.filter(totalData => totalData.name.toLowerCase().includes(this.searchTerm.toLowerCase()));
    }
  }
  
  
}

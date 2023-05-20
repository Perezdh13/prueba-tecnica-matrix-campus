import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchService {
  private apiUrl = 'https://api.punkapi.com/v2/beers';

  constructor(private http: HttpClient) { }

  search(name: string): Observable<any> {
    return this.http.get(`${this.apiUrl}`);
  }
}

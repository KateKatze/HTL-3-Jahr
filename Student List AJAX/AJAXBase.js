function loadDoc(url, method, callback, data = null) {
    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
      if (xhr.readyState === XMLHttpRequest.DONE) {
        if (xhr.status >= 200 && xhr.status < 300) {
          callback(null, xhr.responseText);
        } else {
          callback(new Error('Request failed: ' + xhr.status));
        }
      }
    };
  
    xhr.open(method, url, true);
    if (method === 'POST' || method === 'PUT') {
      xhr.setRequestHeader('Content-Type', 'application/json');
    }
    xhr.send(data ? JSON.stringify(data) : null);
  }
  
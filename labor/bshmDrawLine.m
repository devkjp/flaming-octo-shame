% Besenham Algorithmus

function O = bshmDrawLine(A, startPoint, endPoint)
    % Input Validation
    if ~ isvector(startPoint) || ~ isvector(endPoint)
        error('Start and End Points must be vectors of size 2');
    end
    
    if size(endPoint) ~= 2
        error('Points must have size 2');
    end
    
    % Copy input to output matrix
    O = A;
    
    % Define Parameters
    x1 = startPoint(1);
    x2 = endPoint(1);
    y1 = startPoint(2);
    y2 = endPoint(2);
       
    % Define deltas
    dX = x2 - x1;
    dY = y2 - y1;
    
    % Compute Treshold for y-movement
    eps = dY - dX;
    
    % Iterators
    yi = y1;
    
    % Start Iteration
    for xi=x1:1:x2
        O(xi, yi) = 1;
        if (eps > 0)
            yi = yi + 1;
            eps = eps - dX;
        end
        eps = eps + dY;
    end
end
